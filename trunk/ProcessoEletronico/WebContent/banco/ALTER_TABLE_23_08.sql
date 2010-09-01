alter table lotacao drop lot_tel
alter table lotacao add column tel_cod integer not null references telefone(tel_cod)

alter table lotacao add column lot_diretor_adm varchar(120) 
alter table lotacao add column lot_email varchar(120)

alter table lotacao change lot_diretor lot_diretor_ger varchar(120) 




