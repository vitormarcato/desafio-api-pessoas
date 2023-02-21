package com.attornatus.apipessoas.dtos;

import com.attornatus.apipessoas.entities.Endereco;
import com.attornatus.apipessoas.entities.Pessoa;

import java.util.Set;


public record DadosDetalhamentoEndereco(Long id,

                                        String logradouro,

                                        String cep,

                                        String numero,

                                        String cidade,

                                        Set<Pessoa> pessoasNoEndereco
) {
    public DadosDetalhamentoEndereco(Endereco endereco) {
        this(endereco.getId(), endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade(), endereco.getPessoasNoEndereco());
    }
}
