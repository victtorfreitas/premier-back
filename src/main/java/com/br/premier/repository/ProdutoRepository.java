package com.br.premier.repository;

import com.br.premier.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

  Page<Produto> findAllByEstoqueId(Long id, Pageable pageable);
}
