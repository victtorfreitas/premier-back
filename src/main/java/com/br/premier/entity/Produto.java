package com.br.premier.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_PRODUTO")
public class Produto implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long quantidade;
  private String descricao;
  @Lob
  @Type(type = "org.hibernate.type.BinaryType")
  private byte[] foto;
  private BigDecimal preco;
//  private String tamanho;

  @ManyToOne
  @JsonIgnore
  private Estoque estoque;

  @ManyToOne
  private Tipo tipo;
}
