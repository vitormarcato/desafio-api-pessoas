package com.attornatus.apipessoas.models;

import java.time.LocalDate;

public record DadosAtualizacaoPessoa(
        Long id,
        String nome,
        LocalDate dataNascimento) {

}
