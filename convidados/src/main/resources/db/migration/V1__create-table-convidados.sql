create table convidados(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(11) not null unique,
    convite_id bigint not null

    primary key(id)
    CONSTRAINT fk_convidados_convite FOREIGN KEY (convite_id) REFERENCES convite(id)
);