package com.br.premier.service;

import com.br.premier.dto.response.ProdutoPageResponse;
import com.br.premier.dto.response.TipoResponse;
import com.br.premier.entity.Produto;
import java.util.List;

public interface ProdutoService {

  List<Produto> getProdutos();

  List<TipoResponse> getTiposResponse();

  List<Produto> getProdutosEmpty();

  ProdutoPageResponse getProdutosByEstoque(Long idEstoque, Integer page);
}
