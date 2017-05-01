create database if not exists pronto_socorro;

use pronto_socorro;

CREATE TABLE IF NOT EXISTS medico (
    CRM INT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    especialidade VARCHAR(30) NOT NULL,
    PRIMARY KEY (CRM)
);

CREATE TABLE IF NOT EXISTS medicamento (
    id_medicamento INT NOT NULL AUTO_INCREMENT,
    principio_ativo VARCHAR(80) NOT NULL,
    dosagem VARCHAR(30) NOT NULL,
    contra_indicacao BLOB NULL,
    PRIMARY KEY (id_medicamento)
);