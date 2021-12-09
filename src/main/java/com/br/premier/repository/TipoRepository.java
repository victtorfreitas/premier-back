package com.br.premier.repository;

import com.br.premier.entity.Produto;
import com.br.premier.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo, Long> {
}
