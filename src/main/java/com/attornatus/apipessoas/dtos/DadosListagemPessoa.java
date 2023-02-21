package com.attornatus.apipessoas.dtos;

import com.attornatus.apipessoas.entities.Endereco;
import com.attornatus.apipessoas.entities.Pessoa;

import java.time.LocalDate;
import java.util.Set;

public record DadosListagemPessoa(Long id, String nome, LocalDate nascimento, Set<Endereco> enderecos) {
    public DadosListagemPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getNascimento(), pessoa.getEnderecos());
    }
}
