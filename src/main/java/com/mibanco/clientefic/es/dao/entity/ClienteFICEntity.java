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
         ContactoEntity.class, ConyugeType.class, CupoRotativoType.class,
        DomicilioBaseType.class, DomicilioEmpresaType.class, NegocioType.class, OfertaType.class,
        PasivoType.class, PQRType.class})
public class ClienteFICEntity {


    	private Integer digitoVerificacion;
		private String nombreCompleto;
    	private String razonSocial;
    	private String numeroDocumentoRepresentanteLegal;
    	private String nombreRepresentanteLegal;
    	private Float totalActivos;
    	private String ultimaFechaActualizacion;
    	private String seRequiereActualizacion;
    	private String funcionarioUltimaActualizacion;
    	private EstadoCivilEnum estadoCivil;
    	private String tipoDocumentoRepresentanteLegal;
    	private DomicilioBaseEntity domicilio;
    	private ClienteBaseEntity clienteBase;
    	private NegocioEntity negocio;
    	private DomicilioEmpresaEntity domicilioEmpresa;

}
