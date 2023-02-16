package com.attornatus.apipessoas.models;

import java.time.LocalDate;
import java.util.UUID;

public record DadosCadastroPessoa(
        Long id,
        String nome,
        LocalDate dataNascimento) {

}
