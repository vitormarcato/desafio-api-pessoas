package com.attornatus.apipessoas.models;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizacaoPessoa(
        @NotNull
        Long id,
        String nome,
        LocalDate dataNascimento) {

}
