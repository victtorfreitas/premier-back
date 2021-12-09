package com.br.premier.service;

import com.br.premier.dto.request.EstoqueRequest;
import com.br.premier.dto.response.EstoqueResponse;
import java.util.List;

public interface EstoqueService {

  List<EstoqueResponse> estoques();

  void salvar(EstoqueRequest estoque);
}
