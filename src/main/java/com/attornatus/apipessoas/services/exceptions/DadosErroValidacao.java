package com.attornatus.apipessoas.services.exceptions;

import org.springframework.validation.FieldError;

public record DadosErroValidacao(String campo, String Mensagem) {

    public DadosErroValidacao(FieldError erro){
        this(erro.getField(), erro.getDefaultMessage());
    }

}
