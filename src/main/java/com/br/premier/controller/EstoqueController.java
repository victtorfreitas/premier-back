package com.br.premier.controller;

import com.br.premier.dto.request.EstoqueRequest;
import com.br.premier.dto.response.EstoqueResponse;
import com.br.premier.service.EstoqueService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

  @PostMapping
  public ResponseEntity<?> criar(@RequestBody EstoqueRequest estoque) {
    estoqueService.salvar(estoque);
    return ResponseEntity.ok().build();
  }
}
