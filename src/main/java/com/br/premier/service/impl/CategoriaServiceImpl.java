package com.br.premier.service.impl;

import com.br.premier.dto.response.CategoriaResponse;
import com.br.premier.repository.TipoRepository;
import com.br.premier.service.CategoriaService;
import com.br.premier.service.convert.TipoConvert;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

  private TipoRepository tipoRepository;

  @Override
  public List<CategoriaResponse> getCategorias() {
    return TipoConvert.convertToResponse(tipoRepository.findAll());
  }
}
