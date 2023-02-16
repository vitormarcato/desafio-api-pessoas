package com.attornatus.apipessoas.controllers;

import com.attornatus.apipessoas.models.DadosCadastroPessoa;
import com.attornatus.apipessoas.models.Pessoa;
import com.attornatus.apipessoas.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroPessoa dados) {
        repository.save(new Pessoa(dados));
    }

}
