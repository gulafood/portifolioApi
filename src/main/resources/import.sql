insert into cozinha (id,nome) values (1,'Tailandesa');
insert into cozinha (id,nome) values  (2,'Indiana');




insert into estado  (nome) values ('Minas Gerais');
insert into estado  (nome) values ('São Paulo');


insert into cidade (nome, estado_id) values ('Uberlândia', 1);
insert into cidade (nome, estado_id) values ('Belo Horizonte', 2);


insert into produto(nome,preco,descricao,ativo) values('BIG MAC QUARTERAO',22.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('BIG MAC FELIZ',25.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('BIG MAC BOM DIA',19.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('BIG MAC QUEIJO CHADDAR',42.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('BIG MAC QUEIJO MUSSARELO',28.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('BIG MAC DUPLO QUEIJO CHADDAR',52.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('BIG MAC DUPLO QUEIJO MUSSARELO',33.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('BIG MAC FELIZ DUPLO QUEIJO',92.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('BIG MAC QUARTERAO EM DOBRO',42.90,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('PIZZA DE CALABRESA',12.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('PIZZA DE MUSSARELA ',12.00,'pao, carne, mussarela, chaddar, tomate, alface , molho big mac','true');
insert into produto(nome,preco,descricao,ativo) values('ACAI TA TIJELA ',12.00,'acai , banana, morango, leite condensado, leite ninho','true');
insert into produto(nome,preco,descricao,ativo) values('PICOLE MASTER ',12.00,'leite e chocolate','true');
insert into produto(nome,preco,descricao,ativo) values('PICANHA NA CHAPA ',129.00,'picanha de sol, arroz, feijao tropeiro, mandioca, vinagrete','true');
insert into produto(nome,preco,descricao,ativo) values('COCA COLA  ',12.00,'2 litros','true');
insert into produto(nome,preco,descricao,ativo) values('FANTA LARANJA ',12.00,'2 litros','true');
insert into produto(nome,preco,descricao,ativo) values('FANTA UVA ',12.00,' 2 litros','true');
insert into produto(nome,preco,descricao,ativo) values('CERVEJA HEINEKEN',12.00,'330 ML','true');
insert into produto(nome,preco,descricao,ativo) values('CERVEJA SOL ',12.00,'330 ML','true');
insert into produto(nome,preco,descricao,ativo) values('SUCO LARANJA ',12.00,'500 ML','true');


insert into usuario (email,nome,senha,telefone) values('winston@gmail.com' , 'wisnton' , '123456', '6295887744');

insert into endereco( endereco_bairro , endereco_cep , endereco_numero , endereco_cidade_id, usuario_endereco_id ) values ('sao judas tadeu' , '74585654' , '1000' , 1 , 1);

insert into endereco( endereco_bairro , endereco_cep , endereco_numero , endereco_cidade_id, usuario_endereco_id ) values ('vila nova' , '74585654' , '1000' , 1 , 1);

insert into restaurante(nome,taxa_frete,cozinha_id,endereco_id) values('gula foods',10,1,1);

insert into forma_pagamento (tipo_pagamento) values('avista');

insert into pedido (usario_cliente_id , tipo_pagamento_id , valor_total , sub_total , taxa_frete , status) values(1 , 1 , 88.35 , 88.35 , 19.00 , 1);

insert into itens_pedido (produto_id , pedido_id , quantidade , preco_unitario , preco_total , observacao) values(1 , 1 , 2 , 14.55 , 85.50 , 'bastante molho');
