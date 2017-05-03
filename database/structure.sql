create database if not exists pronto_socorro;

use pronto_socorro;

CREATE TABLE IF NOT EXISTS medico (
    crm INT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    especialidade VARCHAR(30) NOT NULL,
    PRIMARY KEY (crm)
);

CREATE TABLE IF NOT EXISTS paciente (
  cpf VARCHAR(11) NOT NULL,
  nome VARCHAR(50) NOT NULL,
  endereco VARCHAR(70) NULL,
  telefone VARCHAR(20) NULL,
  PRIMARY KEY (cpf));

CREATE TABLE IF NOT EXISTS medicamento (
    id_medicamento INT NOT NULL AUTO_INCREMENT,
    principio_ativo VARCHAR(80) NOT NULL,
    dosagem VARCHAR(30) NOT NULL,
    contra_indicacao BLOB NULL,
    PRIMARY KEY (id_medicamento)
);

CREATE TABLE IF NOT EXISTS doenca (
    cid VARCHAR(5) NOT NULL,
    nome TEXT NOT NULL,
    PRIMARY KEY (cid)
);

CREATE TABLE laboratorio (
    nregistro INT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    telefone VARCHAR(20) NULL,
    tipo VARCHAR(45) NULL,
    responsavel VARCHAR(50) NULL,
    PRIMARY KEY (nregistro)
);

CREATE TABLE consulta (
    medico INT NOT NULL,
    paciente VARCHAR(11) NOT NULL,
    data DATE NULL,
    hora TIME NULL,
    diagnostico TEXT NULL,
    sintomas TEXT NULL,
    observacoes TEXT NULL,
    PRIMARY KEY (medico , paciente),
    CONSTRAINT fk_medico FOREIGN KEY (medico)
        REFERENCES medico (crm),
    CONSTRAINT fk_paciente FOREIGN KEY (paciente)
        REFERENCES paciente (cpf)
);

CREATE TABLE exame (
    id_exame INT NOT NULL AUTO_INCREMENT,
    medico INT NOT NULL,
    paciente VARCHAR(11) NOT NULL,
    tipo VARCHAR(40) NULL,
    data DATE NULL,
    hora TIME NULL,
    informacoes TEXT NULL,
    laudo TEXT NULL,
    laboratorio INT NOT NULL,
    PRIMARY KEY (id_exame),
    INDEX fk_laboratorio_idx (laboratorio ASC),
    INDEX fk_consulta_idx (medico ASC , paciente ASC),
    CONSTRAINT fk_laboratorio FOREIGN KEY (laboratorio)
        REFERENCES laboratorio (nregistro),
    CONSTRAINT fk_consulta FOREIGN KEY (medico , paciente)
        REFERENCES consulta (medico , paciente)
);

