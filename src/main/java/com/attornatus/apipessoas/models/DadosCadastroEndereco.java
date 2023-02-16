package com.attornatus.apipessoas.models;

public record DadosCadastroEndereco(
        Long id,
        String logradouro,
        String cep,
        String numero,
        String cidade) {
}

