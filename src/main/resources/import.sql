insert into cozinha (id,nome) values (1,'Tailandesa');
insert into cozinha (id,nome) values  (2,'Indiana');

insert into estado  (nome) values ('Minas Gerais');
insert into estado  (nome) values ('São Paulo');


insert into cidade (nome, estado_id) values ('Uberlândia', 1);
insert into cidade (nome, estado_id) values ('Belo Horizonte', 2);


insert into produto(nome,preco,descricao,ativo) values('Big Mac Quarterao',22.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('Big Mac Feliz',25.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('Big Mac Bom Dia',19.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('Big Mac Queijo chaddar',42.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('Big Mac Queijo Mussarelo',28.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('Big Mac Duplo Queijo Chaddar',52.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('Big Mac Duplo Queijo Mussarelo',33.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('Big Mac Feliz Duplo Queijo',92.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('Big Mac Quarterao Em Dobro',42.90,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('Big Mac ',12.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');


insert into usuario (email,nome,senha,telefone) values('winston@gmail.com' , 'wisnton' , '123456', '6295887744');

insert into endereco( endereco_bairro , endereco_cep , endereco_numero , endereco_cidade_id, usuario_endereco_id ) values ('sao judas tadeu' , '74585654' , '1000' , 1 , 1);

insert into endereco( endereco_bairro , endereco_cep , endereco_numero , endereco_cidade_id, usuario_endereco_id ) values ('vila nova' , '74585654' , '1000' , 1 , 1);


insert into forma_pagamento (tipo_pagamento) values('avista');

insert into pedido (usario_cliente_id , tipo_pagamento_id , valor_total , sub_total , taxa_frete , status) values(1 , 1 , 88.35 , 88.35 , 19.00 , 1);

insert into itens_pedido (produto_id , pedido_id , quantidade , preco_unitario , preco_total , observacao) values(1 , 1 , 2 , 14.55 , 85.50 , 'bastante molho');
