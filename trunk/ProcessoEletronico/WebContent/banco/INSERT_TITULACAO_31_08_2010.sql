select * from titulacao
update titulacao set tit_desc = 'Ensino Fundamental' where tit_cod = 1;
update titulacao set tit_desc = 'Ensino Médio' where tit_cod = 2;
update titulacao set tit_desc = 'Tecnologo' where tit_cod = 3;
update titulacao set tit_desc = 'Bacharelado' where tit_cod = 4;
insert into titulacao values(5, 'Licenciatura');
insert into titulacao values(6, 'Engenheiro');
insert into titulacao values(7, 'Especialista');
insert into titulacao values(8, 'Mestre');
insert into titulacao values(9, 'Doutor');