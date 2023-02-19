package com.attornatus.apipessoas.controllers;

import com.attornatus.apipessoas.models.*;
import com.attornatus.apipessoas.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroEndereco dados, UriComponentsBuilder uriBuilder) {
        Endereco endereco = new Endereco(dados);
        repository.save(endereco);

        var uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoEndereco(endereco));
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var endereco = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoEndereco(endereco));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosAtualizacaoEndereco dados){
        var endereco = repository.getReferenceById(dados.id());
        endereco.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoEndereco(endereco));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
