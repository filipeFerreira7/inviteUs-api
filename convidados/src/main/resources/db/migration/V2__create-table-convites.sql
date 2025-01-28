create table convites(
  id bigint not null auto_increment,
  anfitriao_id bigint not null,
  data datetime not null

  primary key(id)
  constraint fk_convites_anfitriao_id foreign key (anfitriao_id) references anfitriao(id)
);