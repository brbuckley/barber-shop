CREATE TABLE admin(
       id IDENTITY NOT NULL PRIMARY KEY,
       name VARCHAR NOT NULL,
       username VARCHAR NOT NULL,
       email VARCHAR NOT NULL,
       password_hash VARCHAR NOT NULL
);
CREATE TABLE appointment(
       id IDENTITY NOT NULL PRIMARY KEY,
       status VARCHAR NOT NULL,
       date DATE NOT NULL,
       customer_id BIGINT,
       barber_id BIGINT,
       haircut_id BIGINT,
       payment_id BIGINT,
       queue_id BIGINT
);
CREATE TABLE barber(
       id IDENTITY NOT NULL PRIMARY KEY,
       name VARCHAR NOT NULL,
       username VARCHAR NOT NULL,
       email VARCHAR NOT NULL,
       password_hash VARCHAR NOT NULL,
       address VARCHAR,
       age integer,
       shop_id BIGINT
);
CREATE TABLE city(
       id IDENTITY NOT NULL PRIMARY KEY,
       description VARCHAR NOT NULL,
       state_id BIGINT
);
CREATE TABLE customer(
       id IDENTITY NOT NULL PRIMARY KEY,
       name VARCHAR NOT NULL,
       username VARCHAR NOT NULL,
       email VARCHAR NOT NULL,
       password_hash VARCHAR NOT NULL,
       address VARCHAR,
       age integer,
       birth_day DATE
);
CREATE TABLE haircut(
       id IDENTITY NOT NULL PRIMARY KEY,
       description VARCHAR NOT NULL,
       price NUMERIC NOT NULL
);
CREATE TABLE payment(
       id IDENTITY NOT NULL PRIMARY KEY,
       description VARCHAR NOT NULL
);
CREATE TABLE queue(
       id IDENTITY NOT NULL PRIMARY KEY,
       barber_id BIGINT
);
CREATE TABLE shop(
       id IDENTITY NOT NULL PRIMARY KEY,
       name VARCHAR NOT NULL,
       phone1 VARCHAR NOT NULL,
       phone2 VARCHAR,
       email VARCHAR,
       address VARCHAR NOT NULL,
       city_id BIGINT
);
CREATE TABLE state_table(
       id IDENTITY NOT NULL PRIMARY KEY,
       description VARCHAR NOT NULL
);