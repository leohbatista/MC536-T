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
    PRIMARY KEY (cpf)
);

CREATE TABLE IF NOT EXISTS medicamento (
    id_medicamento INT NOT NULL AUTO_INCREMENT,
    principio_ativo VARCHAR(80) NOT NULL,
    dosagem VARCHAR(30) NOT NULL,
    contra_indicacao TEXT NULL,
    PRIMARY KEY (id_medicamento)
);

CREATE TABLE IF NOT EXISTS doenca (
    cid VARCHAR(5) NOT NULL,
    nome TEXT NOT NULL,
    PRIMARY KEY (cid)
);

CREATE TABLE IF NOT EXISTS laboratorio (
    nregistro INT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    telefone VARCHAR(20) NULL,
    tipo VARCHAR(45) NULL,
    responsavel VARCHAR(50) NULL,
    PRIMARY KEY (nregistro)
);

CREATE TABLE IF NOT EXISTS consulta (
    medico INT NOT NULL,
    paciente VARCHAR(11) NOT NULL,
    data DATE NULL,
    hora TIME NULL,
    diagnostico TEXT NULL,
    sintomas TEXT NULL,
    observacoes TEXT NULL,
    PRIMARY KEY (medico , paciente),
    CONSTRAINT fk_consulta_medico FOREIGN KEY (medico)
        REFERENCES medico (crm),
    CONSTRAINT fk_consulta_paciente FOREIGN KEY (paciente)
        REFERENCES paciente (cpf)
);

CREATE TABLE IF NOT EXISTS exame (
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
    INDEX fk_exame_laboratorio_idx (laboratorio ASC),
    INDEX fk_exame_consulta_idx (medico ASC , paciente ASC),
    CONSTRAINT fk_exame_laboratorio FOREIGN KEY (laboratorio)
        REFERENCES laboratorio (nregistro),
    CONSTRAINT fk_exame_consulta FOREIGN KEY (medico , paciente)
        REFERENCES consulta (medico , paciente)
);

CREATE TABLE IF NOT EXISTS prescricao (
    medico INT NOT NULL,
    paciente VARCHAR(45) NOT NULL,
    medicamento INT NOT NULL,
    posologia TEXT NULL,
    PRIMARY KEY (medico , paciente , medicamento),
    INDEX fk_prescricao_medicamento_idx (medicamento ASC),
    INDEX fk_prescricao_consulta_idx (medico ASC , paciente ASC),
    CONSTRAINT fk_prescricao_consulta FOREIGN KEY (medico , paciente)
        REFERENCES consulta (medico , paciente),
    CONSTRAINT fk_prescricao_medicamento FOREIGN KEY (medicamento)
        REFERENCES medicamento (id_medicamento)
);

CREATE TABLE IF NOT EXISTS diagnostico (
    medico INT NOT NULL,
    paciente VARCHAR(45) NOT NULL,
    doenca VARCHAR(5) NOT NULL,
    PRIMARY KEY (medico , paciente , doenca),
    INDEX fk_diagnostico_doenca_idx (doenca ASC),
    INDEX fk_diagnostico_consulta_idx (medico ASC , paciente ASC),
    CONSTRAINT fk_diagnostico_consulta FOREIGN KEY (medico , paciente)
        REFERENCES consulta (medico , paciente),
    CONSTRAINT fk_diagnostico_doenca FOREIGN KEY (doenca)
        REFERENCES doenca (cid)
);

CREATE TABLE IF NOT EXISTS tratamento (
    medicamento INT NOT NULL,
    doenca VARCHAR(5) NOT NULL,
    descricao TEXT NULL,
    PRIMARY KEY (medicamento , doenca),
    INDEX fk_tratamento_doenca_idx (doenca ASC),
    INDEX fk_tratamento_medicamento_idx (medicamento ASC),
    CONSTRAINT fk_tratamento_medicamento FOREIGN KEY (medicamento)
        REFERENCES medicamento (id_medicamento),
    CONSTRAINT fk_tratamento_doenca FOREIGN KEY (doenca)
        REFERENCES doenca (cid)
);