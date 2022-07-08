package com.br.premier.service;

import com.br.premier.dto.request.ProdutoRequest;
import com.br.premier.dto.response.ProdutoPageResponse;
import com.br.premier.dto.response.ProdutoResponse;
import com.br.premier.dto.response.TipoResponse;
import com.br.premier.entity.Produto;
import java.util.List;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface ProdutoService {

  List<Produto> getProdutos();

  List<TipoResponse> getTiposResponse();

  List<Produto> getProdutosEmpty();

  ProdutoPageResponse getProdutosByEstoque(Long idEstoque, Integer page, String tags,
      Long categoriaId);

  ProdutoResponse getBy(Long id) throws NotFoundException;

  void update(Long id, ProdutoRequest produto) throws NotFoundException;
}
