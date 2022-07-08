package com.br.premier.controller;

import com.br.premier.dto.request.EstoqueRequest;
import com.br.premier.dto.response.EstoqueResponse;
import com.br.premier.dto.response.ProdutoPageResponse;
import com.br.premier.service.EstoqueService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/estoque")
@AllArgsConstructor
public class EstoqueController {

  private EstoqueService estoqueService;

  @GetMapping
  public List<EstoqueResponse> estoques() {
    return estoqueService.estoques();
  }

  @GetMapping("{id}")
  public EstoqueResponse estoque(@PathVariable Long id) {
    return estoqueService.estoque(id);
  }

  @GetMapping("{id}/produto")
  public ProdutoPageResponse produtos(@PathVariable Long id,
      @RequestParam Integer page,
      @RequestParam(required = false, defaultValue = "") String tags,
      Long categoriaId) {
    return estoqueService.produtosByEstoque(id, page, tags, categoriaId);
  }

  @PostMapping
  public ResponseEntity<?> criar(@RequestBody EstoqueRequest estoque) {
    estoqueService.salvar(estoque);
    return ResponseEntity.ok().build();
  }
}
