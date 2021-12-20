package com.br.premier.service.impl;

import com.br.premier.dto.response.ProdutoPageResponse;
import com.br.premier.dto.response.ProdutoPageResponse.Row;
import com.br.premier.dto.response.TipoResponse;
import com.br.premier.entity.Produto;
import com.br.premier.entity.Tipo;
import com.br.premier.repository.ProdutoRepository;
import com.br.premier.repository.TipoRepository;
import com.br.premier.service.ProdutoService;
import com.br.premier.service.convert.ProdutoConvert;
import com.br.premier.service.convert.TipoConvert;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

  @Override
  public ProdutoPageResponse getProdutosByEstoque(Long idEstoque, Integer page) {
    Pageable pg = PageRequest.of(page, ProdutoPageResponse.QTD_ELEMENT);
    val pageProdutos = produtoRepository.findAllByEstoqueId(idEstoque,
        pg);
    List<Produto> produtos = pageProdutos.getContent();
    int size = produtos.size();
    if (size >= ProdutoPageResponse.QTD_ELEMENTS_ROWS) {
      return ProdutoPageResponse.builder()
          .row(getRow(produtos.subList(0, ProdutoPageResponse.QTD_ELEMENTS_ROWS)))
          .row(getRow(produtos.subList(ProdutoPageResponse.QTD_ELEMENTS_ROWS, size)))
          .loadMore(pageProdutos.hasNext())
          .build();
    }
    return ProdutoPageResponse.builder()
        .row(getRow(produtos))
        .loadMore(false)
        .build();
  }

  private Row getRow(List<Produto> produtos) {
    return Row.builder()
        .produtos(ProdutoConvert.convertToPage(produtos))
        .build();
  }
}
