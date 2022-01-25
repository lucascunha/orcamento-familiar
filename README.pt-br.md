# Orçamento Familiar

Este aplicativo está em desenvolvimento como um desafio proposto pelo Alura Challenge Backend.

## Translate to English
- [English](README.md)

# Objetivo
Este projeto consiste em uma API REST desenvolvida em Java com Spring Boot.

Temos um banco de dados MySQL com duas tabelas: Receita e Despesa onde os registros serão cadastrados com base no que o usuário informar.

O usuário pode adicionar, listar, buscar, alterar ou excluir qualquer uma das entradas.

As tabelas possuem os valores: ID, Descrição, Valor, Data e Categoria, conforme descritos abaixo:

* ID: Identifica o registro
* Descrição: Descrição do registro
* Valor: Valor da receita ou despesa
* Data: Data de recebimento da receita ou data de vencimento da despesa
* Categoria: Categoria que classifica a receita ou despesa.

Esta aplicação permite a validação de registos considerando que não podem ser nulos e não podem existir dois ou mais registos com a mesma descrição e data.

O usuário pode filtrar a busca por categoria, por ano e por mês.

# Estrutura das Pastas
* app -> código fonte do aplicativo.
* bd -> esquema de banco de dados
* postman -> coleção que pode ser importada no Postman para manipular a aplicação
