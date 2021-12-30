package com.br.premier.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequest implements Serializable {

  private String nome;
  private Long quantidade;
  private BigDecimal preco;
  private List<String> tags;
  private String foto;
  private Long categoriaId;
  private Long estoqueId;
}
