package com.mibanco.clientefic.es.dao.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class ContactoEntity {

    private String fecha;
    private String tipoContacto;
    private String resultadoComentarios;
    private Integer numeroCliente;

}
