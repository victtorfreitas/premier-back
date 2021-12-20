package com.br.premier.service.convert;

import com.br.premier.dto.response.ProdutoPageResponse.RowProduto;
import com.br.premier.dto.response.ProdutoResponse;
import com.br.premier.entity.Produto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProdutoConvert {

  public List<ProdutoResponse> convert(List<Produto> produtos) {
    Map<String, Long> somatoriaTipo = new HashMap<>();
    produtos.forEach(
        produto -> somatoriaTipo.merge(produto.getTipo().getNome(),
            produto.getQuantidade(), Long::sum)
    );
    return somatoriaTipo.entrySet().stream()
        .map(ProdutoConvert::keysValuesToProdutoResponse)
        .collect(Collectors.toList());
  }

  private ProdutoResponse getProdutoResponse(String tipo, Long quantidade) {
    return ProdutoResponse.builder()
        .tipoProduto(tipo)
        .quantidade(quantidade)
        .build();
  }

  private static ProdutoResponse keysValuesToProdutoResponse(Entry<String, Long> stringLongEntry) {
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
        .imagem(produto.getFoto())
        .nome(produto.getDescricao())
        .preco(produto.getPreco())
        .quantidade(produto.getQuantidade())
        .build();
  }
}
