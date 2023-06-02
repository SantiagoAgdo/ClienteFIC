package com.mibanco.clientefic.es.utils.Exceptions;

public class ClienteFICExceptionObj  extends Exception{

    int status;

    public ClienteFICExceptionObj(){

    }

    public ClienteFICExceptionObj(int status, String msm){
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
