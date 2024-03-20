package com.mibanco.clientefic.es.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@RegisterForReflection
@NoArgsConstructor
@AllArgsConstructor
public class LogRendimientoDTO {

  private String correlationId;
  private String recurso;
  private Date horaFechaInicio;
  private Date horaFechaFin;
  private Integer duracionTotal;
  
}
