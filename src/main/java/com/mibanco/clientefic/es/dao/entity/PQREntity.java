package com.mibanco.clientefic.es.dao.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class PQREntity {

    private Integer numeroCliente;
    private String fecha;
    private Integer numeroPQR;
    private String motivo;
    private String resultadoPQR;
    private String comentario;
}
