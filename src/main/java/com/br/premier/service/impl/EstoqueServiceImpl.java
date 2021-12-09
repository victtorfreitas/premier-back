package com.br.premier.service.impl;

import com.br.premier.dto.request.EstoqueRequest;
import com.br.premier.dto.response.EstoqueResponse;
import com.br.premier.repository.EstoqueRepository;
import com.br.premier.service.EstoqueService;
import com.br.premier.service.ProdutoService;
import com.br.premier.service.convert.EstoqueConvert;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class EstoqueServiceImpl implements EstoqueService {

  private EstoqueRepository estoqueRepository;
  private ProdutoService produtoService;

  @Override
  public List<EstoqueResponse> estoques() {
    val estoques = estoqueRepository.findAll(Sort.by("dataCriacao"));
    val produtosEmpty = produtoService.getProdutosEmpty();
    estoques.stream()
        .filter(estoque -> estoque.getProdutos().isEmpty())
        .forEach(estoque -> estoque.setProdutos(produtosEmpty));
    return EstoqueConvert.convert(estoques);
  }

  @Override
  @Transactional
  public void salvar(EstoqueRequest estoqueRequest) {
    val estoque = EstoqueConvert.convert(estoqueRequest);
    estoqueRepository.save(estoque);
  }
}
