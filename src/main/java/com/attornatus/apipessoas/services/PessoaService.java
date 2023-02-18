package com.attornatus.apipessoas.services;

import com.attornatus.apipessoas.models.Endereco;
import com.attornatus.apipessoas.models.Pessoa;
import com.attornatus.apipessoas.repositories.EnderecoRepository;
import com.attornatus.apipessoas.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Pessoa atribuirEnderecoParaPessoa(Long pessoaId, Long enderecoId) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId).get();
        Endereco endereco = enderecoRepository.findById(enderecoId).get();
        pessoa.getEnderecos().add(endereco);
        return pessoaRepository.save(pessoa);
    }

}
