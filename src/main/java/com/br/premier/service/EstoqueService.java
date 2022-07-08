package com.br.premier.service;

import com.br.premier.dto.request.EstoqueRequest;
import com.br.premier.dto.response.EstoqueResponse;
import com.br.premier.dto.response.ProdutoPageResponse;
import java.util.List;

public interface EstoqueService {

  List<EstoqueResponse> estoques();

  void salvar(EstoqueRequest estoque);

  EstoqueResponse estoque(Long id);

  ProdutoPageResponse produtosByEstoque(Long idEstoque, Integer page, String tags,
      Long categoriaId);
}
