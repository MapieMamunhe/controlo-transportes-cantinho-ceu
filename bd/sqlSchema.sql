	CREATE DATABASE IF NOT EXISTS bd_transporte_cantinho_do_ceu;
    
    USE bd_transporte_cantinho_do_ceu;
    
    CREATE TABLE IF NOT EXISTS `funcionario`(
  `id` BIGINT NOT NULL,
  `nome` VARCHAR(200) NOT NULL,
  `apelido` VARCHAR(45) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `sexo` ENUM('M', 'F') NOT NULL,
  `tipo_documento` ENUM('BI', 'Cartão de Eleitor', 'Carta de Condução', 'Passaporte') NOT NULL,
  `nr_documento` VARCHAR(13) NOT NULL,
  `telefone` VARCHAR(16) NOT NULL,
  `telefone_alternativo` VARCHAR(16) NULL,
  `email` VARCHAR(256) NULL,
  `residencia` TEXT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nr_documento_UNIQUE` (`nr_documento` ASC) VISIBLE,
  UNIQUE INDEX `telefone_UNIQUE` (`telefone` ASC) VISIBLE,
  UNIQUE INDEX `telefone_alternativo_UNIQUE` (`telefone_alternativo` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);
  
  CREATE TABLE IF NOT EXISTS `contaFuncionario`(
	id BIGINT NOT NULL,
    nome_utilizador VARCHAR(30) NOT NULL UNIQUE,
    palavra_passe VARCHAR(100) NOT NULL,
    funcionario_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (funcionario_id) REFERENCES funcionario(id)
  );
  
CREATE TABLE IF NOT EXISTS `motorista`(
	funcionario_id BIGINT NOT NULL,
    PRIMARY KEY(funcionario_id),
    FOREIGN KEY (funcionario_id) REFERENCES funcionario(id)
);
    
CREATE TABLE IF NOT EXISTS `educadora`(
	funcionario_id BIGINT NOT NULL,
    PRIMARY KEY(funcionario_id),
    FOREIGN KEY (funcionario_id) REFERENCES funcionario(id)
);

CREATE TABLE IF NOT EXISTS `grupo`(
	id BIGINT NOT NULL,
    data_formacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_fim TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    motorista_funcionario_id BIGINT NOT NULL,
    educadora_funcionario_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (motorista_funcionario_id) REFERENCES motorista(funcionario_id),
    FOREIGN KEY (educadora_funcionario_id) REFERENCES educadora(funcionario_id)
);
    
ALTER TABLE `grupo`
MODIFY COLUMN data_fim TIMESTAMP;
    
    CREATE TABLE IF NOT EXISTS `viagem`(
		id BIGINT NOT NULL,
        hora_inicio TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        hora_fim TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
        grupo_id BIGINT NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (grupo_id) REFERENCES grupo(id)
    );
    
    ALTER TABLE `viagem`
    MODIFY COLUMN hora_fim TIMESTAMP;
    
    CREATE TABLE IF NOT EXISTS `carrinha`(
		id BIGINT NOT NULL,
        capacidade INT NOT NULL DEFAULT 13,
        lugares_ocupados INT NOT NULL DEFAULT 0,
        matricula VARCHAR(8) NOT NULL,
        PRIMARY KEY (id)
    );
    
    CREATE TABLE IF NOT EXISTS `carrinhaMotorista`(
		id BIGINT NOT NULL,
        data_alocacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        motorista_funcionario_id BIGINT NOT NULL,
        carrinha_id BIGINT NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (motorista_funcionario_id) REFERENCES motorista(funcionario_id),
        FOREIGN KEY (carrinha_id) REFERENCES carrinha(id)
    );
    
    CREATE TABLE IF NOT EXISTS `avaria`(
		id BIGINT NOT NULL,
        tipo VARCHAR(250),
        descricao TEXT,
        PRIMARY KEY(id)
    );
    
    CREATE TABLE IF NOT EXISTS `carrinhaAvaria`(
		id BIGINT NOT NULL,
        data_avaria TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        data_resolucao TIMESTAMP,
        carrinha_id BIGINT NOT NULL,
        avaria_id BIGINT NOT NULL,
        PRIMARY KEY(id),
        FOREIGN KEY (carrinha_id) REFERENCES carrinha(id),
        FOREIGN KEY (avaria_id) REFERENCES avaria(id)
    );
    
    CREATE TABLE IF NOT EXISTS `rota`(
		id BIGINT NOT NULL,
        PRIMARY KEY(id)
    );
    
    CREATE TABLE IF NOT EXISTS `zona`(
		id BIGINT NOT NULL,
        nome VARCHAR (250) NOT NULL,
        cidade ENUM('Maputo', 'Matola') NOT NULL,
        PRIMARY KEY (id)
    );
    
    CREATE TABLE IF NOT EXISTS `zonaRota`(
		id BIGINT NOT NULL,
        data_atribuicao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        data_fim TIMESTAMP,
        rota_id BIGINT NOT NULL,
        zona_id BIGINT NOT NULL,
        PRIMARY KEY(id),
        FOREIGN KEY (rota_id) REFERENCES rota(id),
        FOREIGN KEY (zona_id) REFERENCES zona(id)
    );
    
    CREATE TABLE IF NOT EXISTS `rotaGrupo`(
		id BIGINT NOT NULL,
        data_alocacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        data_fim TIMESTAMP,
        grupo_id BIGINT NOT NULL,
        rota_id BIGINT NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY(grupo_id) REFERENCES grupo(id),
        FOREIGN KEY(rota_id) REFERENCES rota(id)
    );
    
    CREATE TABLE IF NOT EXISTS `encarregado`(
		id BIGINT NOT NULL,
        nome VARCHAR(200) NOT NULL,
        apelido VARCHAR(45) NOT NULL,
        telefone VARCHAR(16),
        telefone_alternativo VARCHAR(16) UNIQUE,
        email VARCHAR(256) UNIQUE,
        PRIMARY KEY(id)
    );
    
    CREATE TABLE IF NOT EXISTS `contaEncarregado`(
		id BIGINT NOT NULL,
        nome_utilizador VARCHAR(30) NOT NULL UNIQUE,
        palavra_passe VARCHAR(100) NOT NULL,
        encarregado_id BIGINT NOT NULL,
        PRIMARY KEY(id),
        FOREIGN KEY(encarregado_id) REFERENCES encarregado(id)
    );
    
    CREATE TABLE IF NOT EXISTS `crianca`(
		id BIGINT NOT NULL,
        nome VARCHAR(200) NOT NULL,
        apelido VARCHAR(45) NOT NULL,
        data_nascimento DATE NOT NULL,
        encarregado_id BIGINT NOT NULL,
        PRIMARY KEY(id),
        FOREIGN KEY(encarregado_id) REFERENCES encarregado(id)
    );
    
    CREATE TABLE IF NOT EXISTS `rotaCrianca`(
		id BIGINT NOT NULL,
        data_alocacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        data_fim TIMESTAMP,
        rota_id BIGINT NOT NULL,
        crianca_id BIGINT NOT NULL,
        PRIMARY KEY(id),
        FOREIGN KEY(rota_id) REFERENCES rota(id),
        FOREIGN KEY(crianca_id) REFERENCES crianca(id)
    );
    
    CREATE TABLE IF NOT EXISTS `entrega`(
		id INT NOT NULL,
        `data` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        educadora_id BIGINT NOT NULL,
        crianca_id BIGINT NOT NULL,
        PRIMARY KEY(id),
        FOREIGN KEY(educadora_id) REFERENCES educadora(funcionario_id),
        FOREIGN KEY(crianca_id) REFERENCES crianca(id)
    );  