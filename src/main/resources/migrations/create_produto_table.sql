--liquibase formatted sql

--changeset jhon:10

create table produtos(
	id_produto  INT NOT NULL AUTO_INCREMENT,
	codigo_barras VARCHAR(13) not null,
	nome VARCHAR (30) NOT NULL,
	descricao VARCHAR(50) NOT NULL,
	quantidade INT NOT NULL,
	categoria VARCHAR(20) NOT NULL,
    CONSTRAINT produto_pk PRIMARY KEY (id_produto)
);


insert into produtos (codigo_barras, nome, descricao, quantidade, categoria)
			    values ('8452236598', 'Caneta BIC Vermelha', 'Caneta esferografica  de cor vermelha', 150, 'CANETAS'),	
					   ('8669532587', 'Caneta BIC Preta', 'Caneta esferografica  de cor preta', 390, 'CANETAS'),
                       ('8227746985', 'Envelope', 'Envelope de papael pardo', 200, 'EMVELOPES'),
                       ('8969656699', 'Lapiseira ponta 0.5', 'Lapiseira ponta 0.5', 80, 'LAPISEIRAS'),
                       ('8569696551', 'Lapiseira ponta 0.7', 'Lapiseira ponta 0.7', 80, 'LAPISEIRAS'),
                       ('8887458596', 'Caderno escolar', 'Caderno escolar', 55, 'CADERNOS')