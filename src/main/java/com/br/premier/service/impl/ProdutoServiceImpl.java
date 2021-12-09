package com.br.premier.service.impl;

import com.br.premier.dto.response.TipoResponse;
import com.br.premier.entity.Produto;
import com.br.premier.entity.Tipo;
import com.br.premier.repository.ProdutoRepository;
import com.br.premier.repository.TipoRepository;
import com.br.premier.service.ProdutoService;
import com.br.premier.service.convert.TipoConvert;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

  private ProdutoRepository produtoRepository;
  private TipoRepository tipoRepository;

  @Override
  public List<Produto> getProdutos() {
    return produtoRepository.findAll();
  }

  @Override
  public List<TipoResponse> getTiposResponse() {
    return TipoConvert.convert(getTipos());
  }

  private List<Tipo> getTipos() {
    return tipoRepository.findAll();
  }

  @Override
  public List<Produto> getProdutosEmpty() {
    return TipoConvert.convertToProduto(getTipos());
  }
}
