-- to create a new database
CREATE DATABASE orcamento-db;

-- to use database
use orcamento-db;

-- creating a new table receita
create table receita (
	id bigint not null auto_increment,
    descricao varchar(100) not null,
    valor decimal(10,2) not null,
    data_vencimento date not null,
    
    primary key (id)
);

create table despesa (
    id bigint not null auto_increment,
    descricao varchar(100) not null,
    valor decimal(10,2) not null,
    data_vencimento date not null,
    categoria varchar(12) not null,
    
    primary key (id)
);

-- to create a new table for category
create table categoria (
    id bigint not null auto_increment,
    descricao varchar(12) not null,
    
    primary key (id)
);

-- to show all tables
show tables;

-- to describe table
desc receita;

desc despesa;

desc categoria;