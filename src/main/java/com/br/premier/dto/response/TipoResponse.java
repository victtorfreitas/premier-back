package com.br.premier.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TipoResponse {

  private String nome;
  private String nomePlural;
}
