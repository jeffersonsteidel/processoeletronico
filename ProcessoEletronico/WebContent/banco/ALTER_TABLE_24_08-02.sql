alter table servidor drop SERV_NOME_MAE 
alter table servidor change serv_nome_mãe serv_nome_mae varchar(120) 
alter table servidor add column end_cod integer not null references endereco(end_cod) 


