package com.attornatus.apipessoas.models;

import java.time.LocalDate;
import java.util.Set;

public record DadosDetalhamentoPessoa(Long id, String nome, LocalDate dataNascimento, Set<Endereco> enderecos) {
    public DadosDetalhamentoPessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento(), pessoa.getEnderecos());
    }
}
