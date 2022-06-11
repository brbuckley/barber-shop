insert into customer (name, username, email, password_hash, address, age, birth_day )
values ('Brendan','brbuckley','brbuckley@id.uff.br','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','Roberto Silveira, 463',23, DATE '1998-12-07');
insert into customer (name, username, email, password_hash)
values ('Paulo','pjniche','pjniche@gmail.com','f89678cc6765848121941f97f563647a0fe77cc7947842dbddb67ba8bacf3c21');
insert into customer (name, username, email, password_hash, age)
values ('Vitor','vitorrocha98','vitorrocha98@gmail.com','6bca70f7710697ed1cd0d259d2d42a43ee4ddbe405f7e520a5194fb1f2e366a9',24);

insert into admin (name, username, email, password_hash)
values ('Brendan','buckleyadmin','brbuckley@id.uff.br','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92');
insert into admin (name, username, email, password_hash)
values ('Vitor','vitoradmin','vitorrocha@id.uff.br','6bca70f7710697ed1cd0d259d2d42a43ee4ddbe405f7e520a5194fb1f2e366a9');
insert into admin (name, username, email, password_hash)
values ('Paulo','pauloadmin','paulojniche@id.uff.br','f89678cc6765848121941f97f563647a0fe77cc7947842dbddb67ba8bacf3c21');

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
values ('Zé','zebarbeiro','zebarbeiro@gmail.com','11253981b29c11f5c01a392db940846a809e2022993ab0ca5d13ae95c3b8456b',1);
insert into barber (name, username, email, password_hash, shop_id)
values ('Pedrinho','pedrinhobarbeiro','pedrinhobarbeiro@gmail.com','75b05094712c2666d6c8b07ed6e710c347539078c1125c0a575009e6bdbd4316',1);

insert into queue (barber_id)
values (1);
insert into queue (barber_id)
values (2);

insert into appointment (status,date,customer_id,barber_id,haircut_id,payment_id,queue_id)
values('Cortando',DATE '2022-06-11',1,1,1,1,1);
insert into appointment (status,date,customer_id,barber_id,haircut_id,payment_id,queue_id)
values('Em espera',DATE '2022-06-11',2,1,2,2,1);
insert into appointment (status,date,customer_id,barber_id,haircut_id,payment_id,queue_id)
values('Cortando',DATE '2022-06-11',3,2,3,3,2);