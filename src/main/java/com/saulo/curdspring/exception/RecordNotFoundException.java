package com.saulo.curdspring.exception;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(Long id){
        super("Registro nao encontrado com o id: " + id);
    }
}
