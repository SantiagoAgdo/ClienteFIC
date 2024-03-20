package com.mibanco.clientefic.es.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultarCupoRotativoOutput {

    private int totalRegistros;
    private List<CupoRotativoEntity> cupoRotativo;

}

