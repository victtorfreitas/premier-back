package com.br.premier.controller;

import com.br.premier.dto.response.CategoriaResponse;
import com.br.premier.service.CategoriaService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/categoria")
@AllArgsConstructor
public class CategoriaController {

  private CategoriaService categoriaService;

  @GetMapping
  public List<CategoriaResponse> categorias() {
    return categoriaService.getCategorias();
  }
}
