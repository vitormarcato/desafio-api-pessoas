package com.attornatus.apipessoas.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.executable.ValidateOnExecution;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

public record DadosCadastroPessoa(
        @NotBlank
        String nome,
        @NotNull
        LocalDate dataNascimento) {

}
