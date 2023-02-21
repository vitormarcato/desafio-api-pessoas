# Desafio Back-End - API Pessoas

Uma API simples, usando Spring Boot, para gerenciar Pessoas.

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
![image](https://user-images.githubusercontent.com/60930603/220408353-20cabed0-3d22-4262-a5e8-335d67cd9466.png)


### Relacionamento das entidades Many-To-Many:

![Diagrama ER](https://user-images.githubusercontent.com/60930603/220407696-dfc89809-8588-4480-b24e-a96399b09714.png)


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
