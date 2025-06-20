CREATE TABLE tb_user (
     id SERIAL PRIMARY KEY,
     name VARCHAR(40),
     cpf VARCHAR(11),
     email VARCHAR(30),
     password VARCHAR(255)
)