alter table documento drop DOC_TIT_ELEIT_DATA_EMI
alter table documento change doc_tit_eleit doc_tit_eleit varchar(13) 
alter table documento change doc_cert_mil_serie doc_cert_mil_serie varchar(1) 
alter table documento change doc_cart_trab_serie doc_cart_trab_serie varchar(5) 