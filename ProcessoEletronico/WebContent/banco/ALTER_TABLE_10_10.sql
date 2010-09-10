alter table servidortitulacao add column serv_tit_curso varchar(100) not null  

create table areaconhecimento(area_conh_cod integer not null auto_increment primary key ,
                              area_conh_desc varchar(40) not null)
                              

alter table servidortitulacao add column area_conh_cod integer not null references areaconhecimento(area_conh_cod)