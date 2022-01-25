# Orcamento Familiar
This application is under development as a challenge proposed by the Alura Challenge Backend.

## Translate to Portuguese
-   [Português](README.pt-br.md)

# Goal
This project consists of a REST API developed in Java with Spring Boot.

We have a MySQL database with two tables: Revenue and Expense where they will be registered based on what the user informs.

The user may register, list, search, change or delete any of the entries.

The tables have the values: Id, Descricao, Valor, Data, and Categoria, described below:

* ID: Identifies the record
* Description: Description of the record
* Value: Amount of income or expense
* Date: Date of receipt of income or due date of the expense
* Category: Category that classifies the income or expense.

This application provides validation of records considering that they cannot be null, there cannot be two or more records with the same description and date.

The user can filter the search by category, by year, and by month.

# Folders
* app -> source code of the application.
* bd -> database schema
* postman -> collection to manipulate the application