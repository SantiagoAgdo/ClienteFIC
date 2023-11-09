package com.mibanco.clientefic.es.dto;

import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.gen.type.EstadoCivilEnum;
import com.mibanco.clientefic.es.gen.type.TipoDocumentoEnum;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class ClienteFICDTO {

    public AlertaEntity alerta;
    public ClienteBaseEntity clienteBase;
    public CentralRiesgoEntity centralRiesgo;
    public ReporteCentralRiesgoEntity reporteCentralRiesgoType;
    public ContactoEntity contacto;
    public ConyugeEntity conyuge;
    public CupoRotativoEntity cupoRotativo;
    public Integer digitoVerificacion;
    public DomicilioBaseEntity domicilio;
    public DomicilioEmpresaEntity domicilioEmpresa;
    public EstadoCivilEnum estadoCivil;
    public String funcionarioUltimaActualizacion;
    public NegocioEntity negocio;
    public String numeroDocumentoRepresentanteLegal;
    public OfertaEntity oferta;
    public PasivoEntity pasivo;
    public PQREntity PQR;
    public String prestamo;
    public String nombreRepresentanteLegal;
    public String razonSocial;
    public String seRequiereActualizacion;
    public TipoDocumentoEnum tipoDocumentoRepresentanteLegal;
    public String totalActivos;
    public String ultimaFechaActualizacion;

}
