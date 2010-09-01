alter table servidor add column tel_cod_fixo varchar(13) not null references telefone(tel_cod)
alter table servidor add column tel_cod_cel varchar(13) references telefone(tel_cod)

