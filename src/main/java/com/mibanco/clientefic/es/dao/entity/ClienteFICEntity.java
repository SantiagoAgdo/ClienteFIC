package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteFICEntity {

    public AlertaType alerta;
    public ClienteBaseType clienteBase;
    public CentralRiesgoType centralRiesgo;
    public ReporteCentralRiesgoType reporteCentralRiesgoType;
    public ContactoEntity contacto;
    public ConyugeType conyuge;
    public CupoRotativoType cupoRotativo;
    public Integer digitoVerificacion;
    public DomicilioType domicilio;
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
