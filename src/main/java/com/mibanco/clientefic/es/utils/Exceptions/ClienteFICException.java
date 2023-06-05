package com.mibanco.clientefic.es.utils.Exceptions;

public class ClienteFICException extends RuntimeException {

    public static final long serialVersionUID =1L;


    int status;

    public ClienteFICException(int status, String msm){
        super(msm);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
