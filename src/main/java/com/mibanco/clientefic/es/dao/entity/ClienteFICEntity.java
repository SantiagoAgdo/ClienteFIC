package com.mibanco.clientefic.es.dao.entity;

import com.mibanco.clientefic.es.gen.type.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ClienteFICEntity {

    private AlertaType alerta;
    private ClienteBaseType clienteBase;
    private CentralRiesgoType centralRiesgo;
    private ContactoEntity contacto;
    private ConyugeType conyuge;
    private CupoRotativoType cupoRotativo;
    private Integer digitoVerificacion;
    private DomicilioType domicilio;
    private DomicilioEmpresaType domicilioEmpresa;
    private EstadoCivilEnum estadoCivil;
    private String funcionarioUltimaActualizacion;
    private NegocioType negocio;
    private String numeroDocumentoRepresentanteLegal;
    private OfertaType oferta;
    private PasivoType pasivo;
    private PQRType PQR;
    private String prestamo;
    private String primerApellidoRepresentanteLegal;
    private String primerNombreRepresentanteLegal;
    private String razonSocial;
    private String segundoApellidoRepresentanteLegal;
    private String segundoNombreRepresentanteLegal;
    private Boolean seRequiereActualizacion;
    private TipoDocumentoEnum tipoDocumentoRepresentanteLegal;
    private Float totalActivos;
    private Date ultimaFechaActualizacion;

    public ClienteFICEntity() {
    }
}
