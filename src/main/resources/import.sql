insert into cozinha (nome) values ('japonesa');
insert into cozinha (nome) values ('brasileira');


insert into estado (nome) values ('goias');
insert into estado (nome) values ('sao paulo');

insert into cidade (nome , estado_id) values ('goiania', 1);
insert into cidade (nome , estado_id) values ('guarulhos', 2);


insert into cozinha (nome) values ('lanches');


insert into forma_pagamento(forma)values('Dinheiro');
insert into forma_pagamento(forma)values('Cartao de Credito');
insert into forma_pagamento(forma)values('Cartao de Debito');


insert into Restaurante(nome,taxa_frete,cozinha_id)values('Macdonalds',5.00,3);

