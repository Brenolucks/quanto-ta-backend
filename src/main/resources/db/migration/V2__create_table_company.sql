CREATE TABLE tb_company (
    id SERIAL PRIMARY KEY,
    cnpj VARCHAR(14) NOT NULL,
    name VARCHAR 40 NOT NULL,
    address VARCHAR(40) NOT NULL,
    number int NOT NULL
);