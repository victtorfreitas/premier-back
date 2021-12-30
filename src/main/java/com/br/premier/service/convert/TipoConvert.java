package com.br.premier.service.convert;

import com.br.premier.dto.response.CategoriaResponse;
import com.br.premier.dto.response.TipoResponse;
import com.br.premier.entity.Produto;
import com.br.premier.entity.Tipo;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TipoConvert {

  public List<TipoResponse> convert(List<Tipo> tipos) {
    return tipos.stream()
        .map(TipoConvert::getTipoResponse)
        .collect(Collectors.toList());
  }

  public List<Produto> convertToProduto(List<Tipo> tipos) {
    return tipos.stream()
        .map(TipoConvert::getProduto)
        .collect(Collectors.toList());
  }

  private Produto getProduto(Tipo tipo) {
    return Produto.builder()
        .tipo(tipo)
        .descricao(tipo.getNome())
        .preco(BigDecimal.ZERO)
        .quantidade(0L)
        .build();
  }

  private TipoResponse getTipoResponse(Tipo tipo) {
    return TipoResponse.builder()
        .nome(tipo.getNome())
        .nomePlural(tipo.getNomePlural())
        .build();
  }

  public static List<CategoriaResponse> convertToResponse(List<Tipo> tipos) {
    return tipos.stream()
        .map(TipoConvert::convertCategoriaResponse)
        .collect(Collectors.toList());
  }

  private static CategoriaResponse convertCategoriaResponse(Tipo tipo) {
    return CategoriaResponse.builder()
        .id(tipo.getId())
        .nome(tipo.getNome())
        .nomePlural(tipo.getNomePlural())
        .build();
  }
}
