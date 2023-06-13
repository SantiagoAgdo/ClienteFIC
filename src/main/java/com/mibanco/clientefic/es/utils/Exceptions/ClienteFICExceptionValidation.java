package com.mibanco.clientefic.es.utils.Exceptions;

public class ClienteFICExceptionValidation extends RuntimeException {

    public static final long serialVersionUID = 1L;


    int status;

    public ClienteFICExceptionValidation(int status, String msm) {
        super(msm);
        this.status = status;
    }

    public ClienteFICExceptionValidation(String msm) {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
