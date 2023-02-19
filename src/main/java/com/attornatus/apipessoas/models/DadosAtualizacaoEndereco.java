package com.attornatus.apipessoas.models;

public record DadosAtualizacaoEndereco(Long id,

                                       String logradouro,

                                       String cep,

                                       String numero,

                                       String cidade,

                                       Boolean enderecoPrincipal) {
}
