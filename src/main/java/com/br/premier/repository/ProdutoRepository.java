package com.br.premier.repository;

import com.br.premier.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

  @Query("select t from TB_PRODUTO t where t.estoque.id = ?1 and t.tags like upper(concat('%', ?2, '%'))")
  Page<Produto> findAllByFilters(Long id, String tags, Pageable pageable);

  @Query("select t from TB_PRODUTO t where t.estoque.id = ?1"
      + " and t.tags like upper(concat('%', ?2, '%'))"
      + " and t.tipo.id = ?3")
  Page<Produto> findAllByFilters(Long idEstoque, String tags, Long categoriaId, Pageable pg);
}
