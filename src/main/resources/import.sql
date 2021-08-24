insert into cozinha (id,nome) values (1,'Tailandesa');
insert into cozinha (id,nome) values  (2,'Indiana');

insert into estado  (nome) values ('Minas Gerais');
insert into estado  (nome) values ('São Paulo');


insert into cidade (nome, estado_id) values ('Uberlândia', 1);
insert into cidade (nome, estado_id) values ('Belo Horizonte', 2);

insert into usuario(nome,email, senha,telefone) values('eduardo santana','eduardo@gmail.com','123456','62999999999');

insert into produto(nome,preco,ativo) values('Big Mac Quarterao',22.00,'true');
insert into produto(nome,preco,ativo) values('Big Mac Feliz',25.00,'true');
insert into produto(nome,preco,ativo) values('Big Mac Bom Dia',19.00,'true');
insert into produto(nome,preco,ativo) values('Big Mac Queijo chaddar',42.00,'true');
insert into produto(nome,preco,ativo) values('Big Mac Queijo Mussarelo',28.00,'true');
insert into produto(nome,preco,ativo) values('Big Mac Duplo Queijo Chaddar',52.00,'true');
insert into produto(nome,preco,ativo) values('Big Mac Duplo Queijo Mussarelo',33.00,'true');
insert into produto(nome,preco,ativo) values('Big Mac Feliz Duplo Queijo',92.00,'true');
insert into produto(nome,preco,ativo) values('Big Mac Quarterao Em Dobro',42.90,'true');
insert into produto(nome,preco,ativo) values('Big Mac ',12.00,'true');




insert into restaurante (nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values ('Thai Gourmet', 10, 1, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');

