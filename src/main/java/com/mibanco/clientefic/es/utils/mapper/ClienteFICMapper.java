package com.mibanco.clientefic.es.utils.mapper;

import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.gen.type.*;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ClienteFICMapper {

    public ClienteFICType clienteFICToType(ClienteFICEntity entity) {
        return new ModelMapper().map(entity, ClienteFICType.class);
    }

    public TipoDocumentoEnum stringATipoDocumento(String documentoTipo){
        return new ModelMapper().map(documentoTipo, TipoDocumentoEnum.class);
    }

    public TipoPersonaEnum stringATipoPersona(String documentoTipo){
        return new ModelMapper().map(documentoTipo, TipoPersonaEnum.class);
    }

    public TipoProductoEnum stringATipoProducto(String documentoTipo){
        return new ModelMapper().map(documentoTipo, TipoProductoEnum.class);
    }

    public TipoViviendaEnum stringATipoVivienda(String documentoTipo){
        return new ModelMapper().map(documentoTipo, TipoViviendaEnum.class);
    }
    public TipoActividadCIIUEnum stringATipoActividadCIIU(String documentoTipo){
        return new ModelMapper().map(documentoTipo, TipoActividadCIIUEnum.class);
    }

    public EstadoCivilEnum stringAEstadoCivil(String documentoTipo){
        return new ModelMapper().map(documentoTipo, EstadoCivilEnum.class);
    }

    public AlertaType alertaToType(AlertaEntity entity) {
        return new ModelMapper().map(entity, AlertaType.class);
    }

    public CentralRiesgoType centralRiesgoFICToType(CentralRiesgoEntity entity) {
        return new ModelMapper().map(entity, CentralRiesgoType.class);
    }

    public ClienteFICEntity clienteFICToEntity(ClienteFICType entity) {
        return new ModelMapper().map(entity, ClienteFICEntity.class);
    }

    public CupoRotativoType cupoRotativoFICToType(CupoRotativoEntity entity) {
        return new ModelMapper().map(entity, CupoRotativoType.class);
    }

    public ContactoType contactoToType(ContactoEntity entity) {
        return new ModelMapper().map(entity, ContactoType.class);
    }

    public OfertaType ofertaToType(OfertaEntity entity) {
        return new ModelMapper().map(entity, OfertaType.class);
    }

    public PasivoType pasivoToType(PasivoEntity entity) {
        return new ModelMapper().map(entity, PasivoType.class);
    }

    public PQRType pqrToType(PQREntity entity) {
        return new ModelMapper().map(entity, PQRType.class);
    }
}
