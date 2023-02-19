package com.attornatus.apipessoas.models;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEndereco(
        @NotNull
        Long id,

        String logradouro,

        String cep,

        String numero,

        String cidade,

        Boolean enderecoPrincipal) {
}
