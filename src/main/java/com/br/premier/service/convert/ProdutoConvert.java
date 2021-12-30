package com.br.premier.service.convert;

import com.br.premier.dto.response.ProdutoEstoqueResponse;
import com.br.premier.dto.response.ProdutoPageResponse.RowProduto;
import com.br.premier.dto.response.ProdutoResponse;
import com.br.premier.entity.Produto;
import com.br.premier.entity.Tipo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProdutoConvert {

  public List<ProdutoEstoqueResponse> convert(List<Produto> produtos) {
    Map<String, Long> somatoriaTipo = new HashMap<>();
    produtos.forEach(
        produto -> somatoriaTipo.merge(produto.getTipo().getNome(),
            produto.getQuantidade(), Long::sum)
    );
    return somatoriaTipo.entrySet().stream()
        .map(ProdutoConvert::keysValuesToProdutoResponse)
        .collect(Collectors.toList());
  }

  private ProdutoEstoqueResponse getProdutoResponse(String tipo, Long quantidade) {
    return ProdutoEstoqueResponse.builder()
        .tipoProduto(tipo)
        .quantidade(quantidade)
        .build();
  }

  private static ProdutoEstoqueResponse keysValuesToProdutoResponse(
      Entry<String, Long> stringLongEntry) {
    return getProdutoResponse(stringLongEntry.getKey(),
        stringLongEntry.getValue());
  }

  public List<RowProduto> convertToPage(List<Produto> produtos) {
    return produtos.stream()
        .map(ProdutoConvert::toRowProduto)
        .collect(Collectors.toList());
  }

  private static RowProduto toRowProduto(Produto produto) {
    return RowProduto.builder()
        .id(produto.getId())
        .imagem(produto.getFoto())
        .nome(produto.getDescricao())
        .preco(produto.getPreco())
        .quantidade(produto.getQuantidade())
        .build();
  }

  public ProdutoResponse convert(Produto produto) {
    Tipo tipo = produto.getTipo();
    List<String> tags = getTags(produto.getTags());
    return ProdutoResponse.builder()
        .descricao(produto.getDescricao())
        .quantidade(produto.getQuantidade())
        .foto(produto.getFoto())
        .tipo(tipo.getId())
        .preco(produto.getPreco())
        .tags(tags)
        .build();
  }

  private static List<String> getTags(String tags) {
    if (tags == null) {
      return new ArrayList<>();
    }
    return List.of(tags.split(","));
  }
}
