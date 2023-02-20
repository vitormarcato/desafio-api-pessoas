package com.attornatus.apipessoas.models.dtos;

import com.attornatus.apipessoas.models.Endereco;
import com.attornatus.apipessoas.models.Pessoa;

import java.time.LocalDate;
import java.util.Set;

public record DadosDetalhamentoPessoa(Long id, String nome, LocalDate nascimento, Set<Endereco> enderecos) {
    public DadosDetalhamentoPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getNascimento(), pessoa.getEnderecos());
    }
}
