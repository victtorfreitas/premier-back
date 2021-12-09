package com.br.premier.controller;

import com.br.premier.dto.response.TipoResponse;
import com.br.premier.entity.Produto;
import com.br.premier.service.ProdutoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/produto")
@AllArgsConstructor
public class ProdutoController {

  private ProdutoService produtoService;

  @GetMapping
  public List<Produto> produtos() {
    return produtoService.getProdutos();
  }

  @GetMapping("/tipo")
  public List<TipoResponse> tipos() {
    return produtoService.getTiposResponse();
  }
}
