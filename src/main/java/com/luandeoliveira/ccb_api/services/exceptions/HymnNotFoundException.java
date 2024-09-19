package com.luandeoliveira.ccb_api.services.exceptions;

public class HymnNotFoundException extends RuntimeException{
    public HymnNotFoundException(String message){
        super(message);
    }
}
