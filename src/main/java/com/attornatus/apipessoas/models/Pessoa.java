package com.attornatus.apipessoas.models;

import com.attornatus.apipessoas.models.dtos.DadosCadastroPessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Table(name = "tb_pessoas")
@Entity(name = "Pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @Column(name = "data_nascimento")
    private LocalDate nascimento;
    @ManyToMany
    @JoinTable(name = "tb_pessoas_enderecos",
            joinColumns = @JoinColumn(name = "pessoa_id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    private Set<Endereco> enderecos = new HashSet<>();

    @Column(name = "id_endereco_principal")
    private Long principal;

    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.nascimento = dados.nascimento();
    }

}
