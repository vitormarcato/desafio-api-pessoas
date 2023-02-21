package com.attornatus.apipessoas.dtos;

import com.attornatus.apipessoas.entities.Pessoa;

import java.time.LocalDate;

public record DadosDetalhamentoPessoa(Long id, String nome, LocalDate nascimento) {
    public DadosDetalhamentoPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getNascimento());
    }
}
