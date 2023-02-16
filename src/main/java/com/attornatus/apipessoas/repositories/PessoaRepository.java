package com.attornatus.apipessoas.repositories;

import com.attornatus.apipessoas.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
