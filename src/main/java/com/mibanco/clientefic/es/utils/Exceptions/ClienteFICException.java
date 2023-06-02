package com.mibanco.clientefic.es.utils.Exceptions;

public class ClienteFICException extends RuntimeException {

    public static final long serialVersionUID =1L;

    public ClienteFICException(String msm){
        super(msm);
    }
}
