package com.attornatus.apipessoas.models;

import com.attornatus.apipessoas.repositories.EnderecoRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table(name = "tb_pessoas")
@Entity(name = "Pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    @ManyToMany
    @JoinTable (name = "tb_pessoas_enderecos", joinColumns = @JoinColumn(name = "pessoa_id"), inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    private Set<Endereco> listaEnderecos = new HashSet<>();


    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
    }
}
