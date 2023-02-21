package com.attornatus.apipessoas.repositories;

import com.attornatus.apipessoas.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
