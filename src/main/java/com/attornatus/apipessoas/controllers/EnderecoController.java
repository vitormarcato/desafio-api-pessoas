package com.attornatus.apipessoas.controllers;

import com.attornatus.apipessoas.models.DadosCadastroEndereco;
import com.attornatus.apipessoas.models.Endereco;
import com.attornatus.apipessoas.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroEndereco dados) {
        repository.save(new Endereco(dados));
    }

}
