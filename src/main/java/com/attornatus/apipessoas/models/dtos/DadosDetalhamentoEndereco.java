package com.attornatus.apipessoas.models.dtos;

import com.attornatus.apipessoas.models.Endereco;
import com.attornatus.apipessoas.models.Pessoa;

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
