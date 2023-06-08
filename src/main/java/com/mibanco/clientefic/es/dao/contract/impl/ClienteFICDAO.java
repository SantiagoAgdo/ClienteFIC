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
    public ClienteFICEntity getClienteByIdentificacion(ConsultaClienteByData data) {

        return list.stream()
                .filter(x -> x.getClienteBase().getNumeroDocumento().equals(data.getNumeroDocumento()))
                .findFirst()
                .orElse(null);
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
                .collect(Collectors.toList());

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
                .collect(Collectors.toList());

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
                .collect(Collectors.toList());

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
                .collect(Collectors.toList());

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
                .collect(Collectors.toList());

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
                .collect(Collectors.toList());

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
