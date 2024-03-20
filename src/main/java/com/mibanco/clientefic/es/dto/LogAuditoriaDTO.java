package com.mibanco.clientefic.es.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import java.util.Date;

@Data
@RegisterForReflection
public class LogAuditoriaDTO {
    
  private String correlationId;
  private String usuario;
  private Date fecha;
  private String hora;
  private String direccionIP;
  private String accion;
  private String resultadoAccion;
  private String recurso;
  private String data;

}
