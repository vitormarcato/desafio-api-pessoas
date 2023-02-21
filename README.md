# Desafio Back-End - API Pessoas

Uma API simples, usando Spring Boot, para gerenciar Pessoas.

![](https://media.giphy.com/media/giDUrT9SAdjwB9rsJu/giphy.gif)

## Objetivo
O objetivo é identificar os conhecimentos quanto às tecnologias utilizadas no cotidiano de desenvolvimento de uma equipe Back-end.

## Desafio

Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:  
  
  •	Criar uma pessoa
  •	Editar uma pessoa
  •	Consultar uma pessoa
  •	Listar pessoas
  •	Criar endereço para pessoa
  •	Listar endereços da pessoa
  •	Poder informar qual endereço é o principal da pessoa  

Uma Pessoa deve ter os seguintes campos:  
  
  •	Nome
  •	Data de nascimento
  •	Endereço:
    •	Logradouro
    •	CEP
    •	Número
    •	Cidade

Requisitos  
 
  •	Todas as respostas da API devem ser JSON  
  •	Banco de dados H2
  
## Resolução
  
  Para o desenvolvimento do projeto, considerei as premissas:

  1.	Uma pessoa pode ter mais de um endereco e um endereco pode ter mais de uma pessoa, no caso de uma familia, por exemplo
  2.	Não deve haver duplicidades de registro.

### Diagramas
---

### Arquitetura:
![image](https://user-images.githubusercontent.com/60930603/220412598-2a4a8242-206b-4f40-8ffb-7fda07f1e869.png)


### Relacionamento das entidades Many-To-Many:
![Diagrama ER](https://user-images.githubusercontent.com/60930603/220413007-a6c507a8-136c-4b82-8de7-f1657ebccbc5.png)


### Tecnologias
---

  - Java 17
  
  - Spring Boot   
  
    - JPA/Hibernate

    - Spring Web MVC

    - SpringDoc

    - Bean Validation

    - Lombok

    - Mckito

    - JUnit
  
  - Maven
  
  - Postman
  
  - H2 (Banco de dados Relacional)  



### Autor
---

Vitor Marcato https://www.linkedin.com/in/vitormarcato/
