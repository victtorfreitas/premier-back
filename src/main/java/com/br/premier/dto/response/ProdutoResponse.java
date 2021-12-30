package com.br.premier.dto.response;

import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Builder
@Getter
public class ProdutoResponse {

  private Long quantidade;
  private String descricao;
  private String foto;
  private BigDecimal preco;
  private Long tipo;

  @Singular
  private List<String> tags;
}
