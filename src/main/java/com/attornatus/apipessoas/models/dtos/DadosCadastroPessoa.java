package com.attornatus.apipessoas.models.dtos;

import com.attornatus.apipessoas.models.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroPessoa(
        @NotBlank
        String nome,
        @NotNull
        LocalDate nascimento,

        Endereco endereco
) {
}
