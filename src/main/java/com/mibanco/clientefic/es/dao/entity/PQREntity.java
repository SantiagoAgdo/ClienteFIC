package com.mibanco.clientefic.es.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PQREntity {

    private Integer numeroCliente;
    private String fecha;
    private Integer numeroPQR;
    private String motivo;
    private String resultadoPQR;
    private String comentario;
}
