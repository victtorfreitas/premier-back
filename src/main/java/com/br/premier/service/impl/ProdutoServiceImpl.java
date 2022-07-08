package com.br.premier.service.impl;

import com.br.premier.dto.request.ProdutoRequest;
import com.br.premier.dto.response.ProdutoPageResponse;
import com.br.premier.dto.response.ProdutoPageResponse.Row;
import com.br.premier.dto.response.ProdutoResponse;
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
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
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
  public ProdutoPageResponse getProdutosByEstoque(Long idEstoque, Integer page, String tags,
      Long categoriaId) {

    val pageProdutos = getPageProdutos(idEstoque, tags, page, categoriaId);

    List<Produto> produtos = pageProdutos.getContent();
    int size = produtos.size();
    if (size >= ProdutoPageResponse.QTD_ELEMENTS_ROWS) {
      return ProdutoPageResponse.builder()
          .row(getRow(produtos.subList(0, ProdutoPageResponse.QTD_ELEMENTS_ROWS)))
          .row(getRow(produtos.subList(ProdutoPageResponse.QTD_ELEMENTS_ROWS, size)))
          .loadMore(pageProdutos.hasNext())
          .qtdProduto(pageProdutos.getNumberOfElements())
          .build();
    }
    return ProdutoPageResponse.builder()
        .row(getRow(produtos))
        .loadMore(false)
        .qtdProduto(pageProdutos.getNumberOfElements())
        .build();
  }

  private Page<Produto> getPageProdutos(Long idEstoque, String tags, Integer page,
      Long categoriaId) {
    Pageable pg = PageRequest.of(page, ProdutoPageResponse.QTD_ELEMENT);

    if (categoriaId == null) {
      return produtoRepository.findAllByFilters(idEstoque, tags, pg);
    }
    return produtoRepository.findAllByFilters(idEstoque, tags, categoriaId, pg);
  }

  @Override
  public ProdutoResponse getBy(Long id) throws NotFoundException {
    Produto produto = getProduto(id);
    return ProdutoConvert.convert(produto);
  }

  private Produto getProduto(Long id) throws NotFoundException {
    return produtoRepository.findById(id)
        .orElseThrow(NotFoundException::new);
  }

  @Override
  public void update(Long id, ProdutoRequest produtoRequest) throws NotFoundException {
    Produto produto = getProduto(id);
    metch(produto, produtoRequest);
    produtoRepository.save(produto);
  }

  private void metch(Produto produto, ProdutoRequest produtoRequest) throws NotFoundException {
    String tags = String.join(",", produtoRequest.getTags()).toUpperCase();
    produto.setDescricao(produtoRequest.getNome());
    produto.setFoto(produtoRequest.getFoto().getBytes());
    produto.setPreco(produtoRequest.getPreco());
    produto.setQuantidade(produtoRequest.getQuantidade());
    produto.setTags(tags);
    produto.setTipo(getTipo(produtoRequest.getCategoriaId()));
  }

  private Tipo getTipo(Long estoqueId) throws NotFoundException {
    return tipoRepository.findById(estoqueId)
        .orElseThrow(NotFoundException::new);
  }

  private Row getRow(List<Produto> produtos) {
    return Row.builder()
        .produtos(ProdutoConvert.convertToPage(produtos))
        .build();
  }
}
