package com.attornatus.apipessoas.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosCadastroPessoa(
        @NotBlank
        String nome,
        LocalDate nascimento
) {
}
