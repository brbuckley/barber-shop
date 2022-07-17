insert into customer (name, username, email, password_hash, address, age, birth_day )
values ('Brendan','brbuckley','brbuckley@gmail.com','senha','Roberto Silveira, 463',23, DATE '1998-12-07');
insert into customer (name, username, email, password_hash)
values ('Paulo','pjniche','pjniche@gmail.com','senha');
insert into customer (name, username, email, password_hash, age)
values ('Vitor','vitorrocha98','vitorrocha98@gmail.com','senha',24);

insert into admin (name, username, email, password_hash)
values ('Brendan','buckleyadmin','brbuckley@id.uff.br','senha');
insert into admin (name, username, email, password_hash)
values ('Vitor','vitoradmin','vitorrocha@id.uff.br','senha');
insert into admin (name, username, email, password_hash)
values ('Paulo','pauloadmin','paulojniche@id.uff.br','senha');

insert into haircut (description, price)
values ('Barba',20);
insert into haircut (description, price)
values ('Cabelo',40);
insert into haircut (description, price)
values ('Barba e Cabelo',50);

insert into payment (description)
values ('Cartão');
insert into payment (description)
values ('Dinheiro');
insert into payment (description)
values ('Pix');

insert into state_table (description)
values ('Rio de Janeiro');

insert into city (description, state_id)
values ('Niterói', 1);
insert into city (description, state_id)
values ('Rio de Janeiro', 1);
insert into city (description, state_id)
values ('São Gonçalo', 1);

insert into shop (name, phone1, phone2, email, address, city_id)
values ('Barbearia do Zé','3741-2500','3741-2600','barbeariadoze@gmail.com','Rua Mem de Sá, 151 - Icaraí',1);

insert into barber (name, username, email, password_hash, shop_id)
values ('Zé','zebarbeiro','zebarbeiro@gmail.com','senha',1);
insert into barber (name, username, email, password_hash, shop_id)
values ('Pedrinho','pedrinhobarbeiro','pedrinhobarbeiro@gmail.com','senha',1);

insert into queue (barber_id)
values (1);
insert into queue (barber_id)
values (2);

insert into appointment (status,date,customer_id,barber_id,haircut_id,payment_id,queue_id)
values(1,DATE '2022-06-11',1,1,1,1,1);
insert into appointment (status,date,customer_id,barber_id,haircut_id,payment_id,queue_id)
values(0,DATE '2022-06-11',2,1,2,2,1);
insert into appointment (status,date,customer_id,barber_id,haircut_id,payment_id,queue_id)
values(1,DATE '2022-06-11',3,2,3,3,2);