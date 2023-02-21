package com.attornatus.apipessoas.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizacaoPessoa(
        @NotNull
        Long id,
        String nome,
        LocalDate nascimento,
        Long principal) {

}
