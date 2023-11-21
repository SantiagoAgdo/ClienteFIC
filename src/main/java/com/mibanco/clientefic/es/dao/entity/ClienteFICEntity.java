package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.*;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection(targets = { AlertaType.class, ClienteBaseType.class, CentralRiesgoType.class,
        ReporteCentralRiesgoType.class, ContactoEntity.class, ConyugeType.class, CupoRotativoType.class,
        DomicilioBaseType.class, DomicilioEmpresaType.class, NegocioType.class, OfertaType.class,
        PasivoType.class, PQRType.class})
public class ClienteFICEntity {

    public AlertaType alerta;
    public ClienteBaseType clienteBase;
    public CentralRiesgoType centralRiesgo;
    public ReporteCentralRiesgoType reporteCentralRiesgoType;
    public ContactoEntity contacto;
    public ConyugeType conyuge;
    public CupoRotativoType cupoRotativo;
    public Integer digitoVerificacion;
    public DomicilioBaseType domicilio;
    public DomicilioEmpresaType domicilioEmpresa;
    public EstadoCivilEnum estadoCivil;
    public String funcionarioUltimaActualizacion;
    public NegocioType negocio;
    public String numeroDocumentoRepresentanteLegal;
    public OfertaType oferta;
    public PasivoType pasivo;
    public PQRType PQR;
    public String prestamo;
    public String nombreRepresentanteLegal;
    public String razonSocial;
    public String seRequiereActualizacion;
    public TipoDocumentoEnum tipoDocumentoRepresentanteLegal;
    public String totalActivos;
    public String ultimaFechaActualizacion;

}
