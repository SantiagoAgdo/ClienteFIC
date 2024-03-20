package com.mibanco.clientefic.es.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultarPasivoOutput {

    private int totalRegistros;
    private List<PasivoEntity> pasivo;

}