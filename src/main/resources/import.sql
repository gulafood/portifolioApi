insert into cozinha (id,nome) values (1,'Tailandesa');
insert into cozinha (id,nome) values  (2,'Indiana');

insert into estado  (nome) values ('Minas Gerais');
insert into estado  (nome) values ('São Paulo');


insert into cidade (nome, estado_id) values ('Uberlândia', 1);
insert into cidade (nome, estado_id) values ('Belo Horizonte', 2);


insert into restaurante (nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_locaduro, endereco_numero, enderenco_bairro) values ('Thai Gourmet', 10, 1, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');

