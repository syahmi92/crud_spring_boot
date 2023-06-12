package com.sangenemy.crudAngular.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) //Run this below method when resource not found
public class ResourceNotFoundException extends RuntimeException{

    //Throw this exception if there is no resources available from the database
    //Note:-> Custom exception
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message); //Pass the message to superclass
    }

}
