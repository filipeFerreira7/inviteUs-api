create table convidados(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(11) not null unique,
    convite_id bigint not null

    primary key(id)
    constraint fk_convidados_convite_id foreign key (convite_id) references convite(id)
);