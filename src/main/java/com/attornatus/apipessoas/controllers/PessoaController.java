package com.attornatus.apipessoas.controllers;

import com.attornatus.apipessoas.models.DadosCadastroPessoa;
import com.attornatus.apipessoas.models.DadosDetalhamentoPessoa;
import com.attornatus.apipessoas.models.Pessoa;
import com.attornatus.apipessoas.repositories.PessoaRepository;
import com.attornatus.apipessoas.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository repository;
    @Autowired
    private PessoaService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder) {
        Pessoa pessoa = new Pessoa(dados);
        repository.save(pessoa);

        var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoa(pessoa));
    }

    @PutMapping("/{pessoaId}/enderecos/{enderecoId}")
    @Transactional
    public ResponseEntity atribuirEnderecoParaPessoa(@PathVariable Long pessoaId, @PathVariable Long enderecoId){
        var pessoa = service.atribuirEnderecoParaPessoa(pessoaId, enderecoId);
        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar (@PathVariable Long id){
        var pessoa = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }


}
