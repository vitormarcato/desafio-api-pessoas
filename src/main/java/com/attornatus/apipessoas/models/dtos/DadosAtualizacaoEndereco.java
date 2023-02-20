package com.attornatus.apipessoas.models.dtos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEndereco(
        @NotNull
        Long id,

        String logradouro,

        String cep,

        String numero,

        String cidade) {
}
