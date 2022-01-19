-- to create a new database
CREATE DATABASE orcamento-db;

-- to use database
use nodedb;

-- creating a new table receita
create table receita (
	id bigint not null auto_increment,
    descricao varchar(100) not null,
    valor decimal(10,2) not null,
    data_vencimento varchar(10) not null,
    
    primary key (id)
);

create table despesa (
    id bigint not null auto_increment,
    descricao varchar(100) not null,
    valor decimal(10,2) not null,
    data_vencimento varchar(10) not null,
    
    primary key (id)
);

-- to show all tables
show tables;

-- to describe table
desc receita;

desc despesa;