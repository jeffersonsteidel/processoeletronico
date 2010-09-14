create table emprego (emp_cod integer primary key auto_increment,
emp_cargo varchar(80) not null,
emp_data_adm date not null,
emp_data_saida date not null,
emp_empresa varchar(100) not null,
emp_atividade varchar(250) not null,
serv_cod integer not null references servidor(serv_cod))

