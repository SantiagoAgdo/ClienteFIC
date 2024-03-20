package com.mibanco.clientefic.es.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@Data
@RegisterForReflection
public class LogExcepcionDTO {

  private String correlationId;
  private String recurso;
  private String excepcion;

}