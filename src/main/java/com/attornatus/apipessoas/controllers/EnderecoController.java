package com.attornatus.apipessoas.controllers;

import com.attornatus.apipessoas.models.Endereco;
import com.attornatus.apipessoas.models.dtos.DadosAtualizacaoEndereco;
import com.attornatus.apipessoas.models.dtos.DadosCadastroEndereco;
import com.attornatus.apipessoas.models.dtos.DadosDetalhamentoEndereco;
import com.attornatus.apipessoas.repositories.EnderecoRepository;
import com.attornatus.apipessoas.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoRepository repository;
    @Autowired
    private EnderecoService service;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEndereco dados, UriComponentsBuilder uriBuilder) {
        Endereco endereco = new Endereco(dados);
        service.cadastrarEndereco(endereco);
        var uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEndereco(endereco));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var endereco = service.findById(id).get();
        return ResponseEntity.ok(new DadosDetalhamentoEndereco(endereco));
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody DadosAtualizacaoEndereco dados) {
        var endereco = service.findById(dados.id()).get();
        service.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoEndereco(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
