package com.mibanco.clientefic.es.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactoEntity {

    private String fecha;
    private String tipoContacto;
    private String resultadoComentarios;
    private Integer numeroCliente;

}
