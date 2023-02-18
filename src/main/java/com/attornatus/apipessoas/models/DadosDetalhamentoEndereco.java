package com.attornatus.apipessoas.models;

import java.util.Set;


public record DadosDetalhamentoEndereco(Long id,

         String logradouro,

         String cep,

         String numero,

         String cidade,

         Boolean enderecoPrincipal,

         Set<Pessoa> pessoasNoEndereco
) {
    public DadosDetalhamentoEndereco(Endereco endereco){
        this(endereco.getId(), endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade(), endereco.getEnderecoPrincipal(), endereco.getPessoasNoEndereco());
    }
}
