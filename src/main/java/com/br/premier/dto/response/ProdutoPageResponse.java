package com.br.premier.dto.response;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Builder
@Getter
@AllArgsConstructor
public class ProdutoPageResponse {

  public static final Integer QTD_ELEMENTS_ROWS = 4;
  public static final Integer QTD_ELEMENT = 8;

  @Singular
  private List<Row> rows;
  private boolean loadMore;
  private Integer qtdProduto;

  @Getter
  @Builder
  @AllArgsConstructor
  public static class Row {

    private List<RowProduto> produtos;
  }

  @Getter
  @Builder
  @AllArgsConstructor
  public static class RowProduto {

    private Long id;
    private String imagem;
    private String nome;
    private BigDecimal preco;
    private Long quantidade;
  }
}
