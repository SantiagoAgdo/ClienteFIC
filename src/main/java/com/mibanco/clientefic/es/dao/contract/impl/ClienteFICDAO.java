package com.mibanco.clientefic.es.dao.contract.impl;

import com.mibanco.clientefic.es.dao.contract.IClienteFICDao;
import com.mibanco.clientefic.es.dao.entity.*;
import com.mibanco.clientefic.es.gen.type.*;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClienteFICDAO implements IClienteFICDao {

    List<ClienteFICEntity> list = new ArrayList<>();

    @Override
    public void crearClienteFIC(ClienteFICEntity clienteFIC) {
        list.add(clienteFIC);
    }

    @Override
    public List<AlertaEntity> getListaAlertas(ConsultaClienteByData data) {
        List<ClienteFICEntity> cliente = list.stream()
                .filter(x -> x.getClienteBase().getTipoDocumento() == data.getTipoDocumento())
                .filter(x -> x.getClienteBase().getNumeroDocumento().equals(data.getNumeroDocumento()))
                .filter(x -> x.getDigitoVerificacion().equals(data.getDigitoVerificacion()))
                .toList();

        List<AlertaEntity> query = new ArrayList<>();

        if (cliente.size() != 0) {
            for (ClienteFICEntity cli : cliente) {
                AlertaEntity dataAlert = new AlertaEntity(
                        cli.getAlerta().getTipoAlerta(),
                        cli.getAlerta().getBanco(),
                        cli.getAlerta().getFecha(),
                        cli.getAlerta().getTipoDocumento(),
                        cli.getAlerta().getNumeroDocumento(),
                        cli.getAlerta().getDigitoVerificacion()
                );
                query.add(dataAlert);
            }
        } else {
            return query;
        }

        return query;
    }

    @Override
    public List<CentralRiesgoEntity> getListaCentralRiesgo(ConsultaClienteByData data) {
        List<ClienteFICEntity> cliente = list.stream()
                .filter(x -> x.getClienteBase().getTipoDocumento() == data.getTipoDocumento())
                .filter(x -> x.getClienteBase().getNumeroDocumento().equals(data.getNumeroDocumento()))
                .filter(x -> x.getDigitoVerificacion().equals(data.getDigitoVerificacion()))
                .toList();

        List<CentralRiesgoEntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            CentralRiesgoEntity dataCentral = new CentralRiesgoEntity(
                    cli.getCentralRiesgo().getAntiguedadUbicacion(),
                    cli.getCentralRiesgo().getConsultaDetallada(),
                    cli.getCentralRiesgo().getEstadoDocumento(),
                    cli.getCentralRiesgo().getFechaConsultaMasReciente(),
                    cli.getCentralRiesgo().getFechaExpedicion(),
                    cli.getCentralRiesgo().getGenero(),
                    cli.getCentralRiesgo().getLugarExpedicion(),
                    cli.getCentralRiesgo().getNumeroDocumento(),
                    cli.getCentralRiesgo().getRangoEdad(),
                    cli.getCentralRiesgo().getResultadoConsultaMasReciente(),
                    cli.getCentralRiesgo().getTieneRUT(),
                    cli.getCentralRiesgo().getTipoDocumento(),
                    cli.getCentralRiesgo().getTipoRelacion(),
                    cli.getCentralRiesgo().getTipoReporte(),
                    cli.getCentralRiesgo().getVbVigenteParaSerConsultado(),
                    cli.getCentralRiesgo().getDigitoVerificacion()
            );
            query.add(dataCentral);
        }
        return query;
    }

    @Override
    public ClienteFICEntity getClienteByIdentificacion(ConsultaClienteByData data) {

        return list.stream()
                .filter(x -> x.getClienteBase().getNumeroDocumento().equals(data.getNumeroDocumento()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public ConsultarClientePorNombreOutputEntity getClienteByNombre(String nombre) {

        ClienteFICEntity cliente = list.stream()
                .filter(x -> x.getClienteBase().getPrimerNombre().equals(nombre))
                .findFirst()
                .orElse(null);

        ConsultarClientePorNombreEntity query = new ConsultarClientePorNombreEntity(
                cliente.getClienteBase().getTipoDocumento(),
                cliente.getClienteBase().getNumeroDocumento(),
                cliente.getClienteBase().getPrimerNombre() + " " + cliente.getClienteBase().getPrimerApellido());

        return new ConsultarClientePorNombreOutputEntity(1, query);
    }

    @Override
    public ConyugeType getConyuge(Integer numeroCliente) {
        ClienteFICEntity conyuge = list.stream()
                .filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente))
                .findFirst()
                .orElse(null);

        return conyuge.getConyuge();
    }

    @Override
    public List<CupoRotativoEntity> getCupoRotativo(Integer numeroCliente) {
        List<ClienteFICEntity> cliente = list.stream()
                .filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente))
                .toList();

        List<CupoRotativoEntity> cupoRotativoList = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            CupoRotativoEntity cup = new CupoRotativoEntity(
                    cli.getCupoRotativo().getEstado(),
                    cli.getCupoRotativo().getFechaDeVencimiento(),
                    cli.getCupoRotativo().getMontoCupoCredito(),
                    cli.getCupoRotativo().getMontoUtilizado(),
                    cli.getCupoRotativo().getNumeroCliente(),
                    cli.getCupoRotativo().getNumeroCupo(),
                    cli.getCupoRotativo().getSaldoDisponible()
            );
            cupoRotativoList.add(cup);
        }
        return cupoRotativoList;
    }

    @Override
    public List<ConsultarDirrecionTelefonoEntity> getDirrecionTelefono(Integer numeroCliente) {
        List<ClienteFICEntity> cliente = list.stream()
                .filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente))
                .toList();

        List<ConsultarDirrecionTelefonoEntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            ConsultarDirrecionTelefonoEntity data = new ConsultarDirrecionTelefonoEntity(
                    cli.getNegocio().getDireccion(),
                    cli.getNegocio().getTelefono(),
                    cli.getDomicilio().getTipoVivienda(),
                    cli.getDomicilioEmpresa().getTipoLocal(),
                    TipoDireccionEnum.EMPR_EMPRESA, //QUEMADO
                    DepartamentoEnum._11_BOGOTA_D_C_, //QUEMADO
                    CiudadEnum._05001_MEDELLIN, //QUEMADO
                    BarrioEnum.SINDATAENMODELING, //QUEMADO
                    cli.getNegocio().getTelefono()
            );
            query.add(data);
        }
        return query;
    }

    @Override
    public List<ContactoEntity> getContacto(Integer numeroCliente) {
        List<ClienteFICEntity> cliente = list.stream()
                .filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente))
                .toList();

        List<ContactoEntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            ContactoEntity data = new ContactoEntity(
                    cli.getContacto().getFecha(),
                    cli.getContacto().getTipoContacto(),
                    cli.getContacto().getResultadoComentarios(),
                    cli.getContacto().getNumeroCliente()
            );
            query.add(data);
        }
        return query;
    }

    @Override
    public List<OfertaEntity> getOferta(Integer numeroCliente) {
        List<ClienteFICEntity> cliente = list.stream()
                .filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente))
                .toList();

        List<OfertaEntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            OfertaEntity data = new OfertaEntity(
                    cli.getOferta().getNumeroOferta(),
                    cli.getOferta().getTipoLead(),
                    cli.getOferta().getTipoOferta(),
                    cli.getOferta().getMonto(),
                    cli.getOferta().getPlazo(),
                    cli.getOferta().getNumeroCliente(),
                    cli.getOferta().getTipoDeLiga(),
                    cli.getOferta().getCondicionGarantia()
            );
            query.add(data);
        }
        return query;
    }

    @Override
    public List<PasivoEntity> getPasivo(Integer numeroCliente) {
        List<ClienteFICEntity> cliente = list.stream()
                .filter(x -> x.getClienteBase().getNumeroDocumento().equals(numeroCliente))
                .toList();

        List<PasivoEntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            PasivoEntity data = new PasivoEntity(
                    cli.getPasivo().getNumeroProducto(),
                    cli.getPasivo().getSubProducto(),
                    cli.getPasivo().getEstadoPasivo(),
                    cli.getPasivo().getFechaApertura(),
                    cli.getPasivo().getFechaCierre(),
                    cli.getPasivo().getCapital(),
                    cli.getPasivo().getIntereses(),
                    cli.getPasivo().getOtros(),
                    cli.getPasivo().getSaldoTotal(),
                    cli.getPasivo().getNumeroCliente()
            );
            query.add(data);
        }
        return query;
    }

    @Override
    public List<PQREntity> getPQR(ConsultaClienteByData data) {

        List<ClienteFICEntity> cliente = list.stream()
                .filter(x -> x.getClienteBase().getNumeroDocumento().equals(data.getNumeroDocumento()))
                .filter(x -> x.getClienteBase().getTipoDocumento() == data.getTipoDocumento())
                .filter(x -> x.getDigitoVerificacion().equals(data.getDigitoVerificacion()))
                .toList();

        List<PQREntity> query = new ArrayList<>();
        for (ClienteFICEntity cli : cliente) {
            PQREntity pqr = new PQREntity(
                    cli.getPQR().getFecha(),
                    cli.getPQR().getNumeroPQR(),
                    cli.getPQR().getMotivo(),
                    cli.getPQR().getResultadoPQR(),
                    cli.getPQR().getComentario(),
                    cli.getPQR().getDigitoVerificacion(),
                    cli.getPQR().getTipoDocumento(),
                    cli.getPQR().getNumeroDocumento()
            );
            query.add(pqr);
        }
        return query;
    }


}
