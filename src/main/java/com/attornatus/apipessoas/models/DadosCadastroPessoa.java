package com.attornatus.apipessoas.models;

import java.time.LocalDate;
import java.util.UUID;

public record DadosCadastroPessoa(

        String nome,
        LocalDate dataNascimento,

        DadosCadastroEndereco endereco) {

}
