CREATE TABLE tb_accounts (
    id SERIAL PRIMARY KEY,
    first_name varchar(150),
    second_name varchar(150),
    email varchar(150) UNIQUE
);