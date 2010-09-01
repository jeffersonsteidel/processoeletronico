alter table documento change doc_cart_trab doc_cart_trab integer null
alter table documento change doc_cart_trab_serie doc_cart_trab_serie integer null
alter table documento change est_cod_cart_trab_uf est_cod_cart_trab_uf integer null
alter table documento change doc_cart_trab_data_exp doc_cart_trab_data_exp date null
alter table documento change doc_pis doc_pis varchar(16) null

alter table documento change doc_tit_eleit doc_tit_eleit integer null
alter table documento change est_cod_uf_tit_eleit est_cod_uf_tit_eleit integer null
alter table documento change doc_tit_eleit_zona doc_tit_eleit_zona integer null
alter table documento change doc_tit_eleit_secao doc_tit_eleit_secao integer null
alter table documento change doc_tit_eleit_data_emi doc_tit_data_emi date null


desc documento