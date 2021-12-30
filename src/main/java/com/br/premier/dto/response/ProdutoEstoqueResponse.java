package com.br.premier.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProdutoEstoqueResponse {

  private String tipoProduto;
  private Long quantidade;
}
