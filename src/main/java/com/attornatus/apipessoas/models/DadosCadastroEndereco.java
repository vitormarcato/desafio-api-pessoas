package com.attornatus.apipessoas.models;

public record DadosCadastroEndereco(
        String logradouro,
        String cep,
        String numero,
        String cidade,
        Boolean enderecoPrincipal) {
}


