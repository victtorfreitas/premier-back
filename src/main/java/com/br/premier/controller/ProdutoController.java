package com.br.premier.controller;

import com.br.premier.dto.request.ProdutoRequest;
import com.br.premier.dto.response.ProdutoResponse;
import com.br.premier.dto.response.TipoResponse;
import com.br.premier.entity.Produto;
import com.br.premier.service.ProdutoService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @SneakyThrows
  @GetMapping("/{id}")
  public ProdutoResponse produto(@PathVariable Long id) {
    return produtoService.getBy(id);
  }

  @SneakyThrows
  @PostMapping("/{id}") // TODO: 19/05/2022 Mudar para PUT
  public void update(@PathVariable Long id,
      @RequestBody ProdutoRequest produto) {
    produtoService.update(id, produto);
  }
}
