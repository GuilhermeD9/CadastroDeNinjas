-- V3: Migrations do banco H2 para o banco PostgreSQL


CREATE TABLE IF NOT EXISTS TB_MISSOES (
    ID BIGSERIAL PRIMARY KEY,
    DIFICULDADE VARCHAR(255),
    NOME VARCHAR(255)
);

INSERT INTO TB_MISSOES (DIFICULDADE, NOME)
VALUES ('Facil', 'Missao Teste'),
       ('Facil', 'Missao teste 2');

CREATE TABLE IF NOT EXISTS TB_CADASTRO (
    ID BIGSERIAL PRIMARY KEY,
    EMAIL VARCHAR(255) UNIQUE,
    IDADE INT,
    IMG_URL VARCHAR(255),
    NOME VARCHAR(255),
    MISSOES_ID BIGINT REFERENCES TB_MISSOES(ID),
    RANK VARCHAR(255)
);

INSERT INTO TB_CADASTRO (EMAIL, IDADE, IMG_URL, NOME, MISSOES_ID, RANK)
VALUES ('kakashi@email.com', 36, 'https://.../kakashi.png', 'Kakashi Hatake', 2, NULL),
       ('sakura@email.com', 15, 'https://.../sakura.png', 'Sakura Haruno', 1, NULL);