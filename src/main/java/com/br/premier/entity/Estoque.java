package com.br.premier.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString.Exclude;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_ESTOQUE")
public class Estoque implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Exclude
  @OneToMany(mappedBy = "estoque", cascade = CascadeType.ALL)
  private List<Produto> produtos;

  private String nome;
  private String descricao;
  private BigDecimal total;

  @CreationTimestamp
  @Column(name = "DATA_CRIACAO")
  private ZonedDateTime dataCriacao;

  @Override
  public boolean equals(Object object) {
    if (object == null || Hibernate.getClass(this) != Hibernate.getClass(object)) {
      return false;
    }
    Estoque estoque = (Estoque) object;
    return id != null && Objects.equals(id, estoque.id);
  }

  public BigDecimal getTotalProdutos() {
    return produtos.stream()
        .map(Produto::getPreco)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
