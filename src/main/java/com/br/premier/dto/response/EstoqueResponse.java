package com.br.premier.dto.response;

import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EstoqueResponse {

  private Long id;
  private String nome;
  private String descricao;
  private BigDecimal total;
  private List<ProdutoResponse> produtos;
}
