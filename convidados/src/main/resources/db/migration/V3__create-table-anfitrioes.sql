create table anfitrioes(
                           id bigint not null auto_increment,
                           nome varchar(100) not null,
                           email varchar(100) not null unique,
                           cpf varchar(11) not null unique,
                           data datetime not null,
                           total_convites integer (15)

                               primary key(id)
    );