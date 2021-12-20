package com.br.premier.service.convert;

import com.br.premier.dto.request.EstoqueRequest;
import com.br.premier.dto.response.EstoqueResponse;
import com.br.premier.entity.Estoque;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EstoqueConvert {

  public List<EstoqueResponse> convert(List<Estoque> estoques) {
    return estoques.stream()
        .map(EstoqueConvert::getEstoqueResponse)
        .collect(Collectors.toList());
  }

  private EstoqueResponse getEstoqueResponse(Estoque estoque) {
    return EstoqueResponse.builder()
        .id(estoque.getId())
        .nome(estoque.getNome())
        .descricao(estoque.getDescricao())
        .total(estoque.getTotalProdutos())
        .produtos(ProdutoConvert.convert(estoque.getProdutos()))
        .build();
  }

  public Estoque convert(EstoqueRequest estoqueRequest) {
    return Estoque.builder()
        .descricao(estoqueRequest.getDescricao())
        .nome(estoqueRequest.getNome())
        .total(BigDecimal.ZERO)
        .build();
  }

  public EstoqueResponse convert(Estoque estoque) {
    return EstoqueResponse.builder()
        .nome(estoque.getNome())
        .descricao(estoque.getDescricao())
        .total(estoque.getTotalProdutos())
        .build();
  }
}
