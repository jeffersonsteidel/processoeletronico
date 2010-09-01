alter table contabancaria add column cont_ban_ind_poupanca bit not null
alter table cargo add column carg_cod_identificador varchar(7) not null

create table tipofuncao(
  tip_func_cod integer not null auto_increment primary key,
  tip_func_desc varchar(80) not null);
  
 
