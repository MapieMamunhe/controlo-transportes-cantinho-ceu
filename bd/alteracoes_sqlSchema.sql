/*ALTERAÇÕES*/
SET FOREIGN_KEY_CHECKS = 0;

ALTER TABLE funcionario
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE funcionario
MODIFY COLUMN telefone_alternativo VARCHAR(16) UNIQUE;

 ALTER TABLE contafuncionario
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE grupo
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE `grupo`
MODIFY COLUMN data_fim TIMESTAMP;

ALTER TABLE viagem
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE `viagem`
MODIFY COLUMN hora_fim TIMESTAMP;

ALTER TABLE carrinha
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE carrinhamotorista
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE avaria
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE carrinhaavaria
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE rota
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE zona
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE zonarota
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE rotagrupo
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE encarregado
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE contaencarregado
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE avaria
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE rotacrianca
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE entrega
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE carrinha
ADD COLUMN data_registo TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE avaria 
DROP COLUMN descricao;

ALTER TABLE funcionario
ADD COLUMN data_registo TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
ADD COLUMN data_actualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

ALTER TABLE contafuncionario
ADD COLUMN data_registo TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
ADD COLUMN data_actualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

ALTER TABLE avaria
ADD COLUMN data_registo TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
ADD COLUMN data_actualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

ALTER TABLE grupo
ADD COLUMN data_registo TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
ADD COLUMN data_actualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

ALTER TABLE rota
ADD COLUMN data_registo TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
ADD COLUMN data_actualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

ALTER TABLE zona
ADD COLUMN data_registo TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
ADD COLUMN data_actualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

ALTER TABLE encarregado
ADD COLUMN data_registo TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
ADD COLUMN data_actualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

ALTER TABLE contaencarregado
ADD COLUMN data_registo TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
ADD COLUMN data_actualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

ALTER TABLE crianca
DROP FOREIGN KEY crianca_ibfk_1;

ALTER TABLE crianca
DROP COLUMN encarregado_id;

CREATE TABLE IF NOT EXISTS crianca_encarregado(
	crianca_id BIGINT NOT NULL,
    encarregado_id BIGINT NOT NULL,
    PRIMARY KEY(crianca_id, encarregado_id),
    FOREIGN KEY (crianca_id) REFERENCES crianca(id),
    FOREIGN KEY (encarregado_id) REFERENCES encarregado(id)
);

ALTER TABLE carrinha
MODIFY COLUMN matricula VARCHAR(50) NOT NULL UNIQUE;

CREATE TABLE IF NOT EXISTS perfil(
	id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY(id)
);

INSERT INTO perfil(nome)
VALUES
	('Administrador'),
	('Educadora'),
    ('Gestor de transportes'),
	('Motorista'),
    ('Secretária');


ALTER TABLE contafuncionario
ADD COLUMN perfil_id BIGINT NOT NULL, 
ADD FOREIGN KEY (perfil_id) REFERENCES perfil(id);

ALTER TABLE contafuncionario
DROP COLUMN nome_utilizador;

DROP TABLE IF EXISTS funcionario_residencia;
CREATE TABLE funcionario_residencia(
	id BIGINT NOT NULL AUTO_INCREMENT,
    quarteirao INT NOT NULL,
    id_funcionario BIGINT NOT NULL UNIQUE,
    id_zona BIGINT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_funcionario) REFERENCES funcionario(id),
    FOREIGN KEY(id_zona) REFERENCES zona(id)
);

/*Migrar dados da coluna residência da tabela funcionario para a tabela funcionario_residecia*/
DELIMITER $$
DROP PROCEDURE IF EXISTS migrar_residencia$$
CREATE PROCEDURE migrar_residencia()
	BEGIN
		DECLARE i INT DEFAULT 0;
        DECLARE j INT DEFAULT 0;
        DECLARE _id_zona INT;
        DECLARE _id_funcionario INT;
        DELETE FROM funcionario_residencia;
 
		/*Selecionar id de cada zona*/
        pega_zona: LOOP
			/*ID DE ZONAS*/
			SELECT id INTO _id_zona FROM zona WHERE nome = ANY (SELECT LEFT(residencia, length(residencia)-8) FROM funcionario) LIMIT i, 1;
			SET j = 0;
                /*Selecionar id de funcionario cuja residencia e igual a zona correspodente ao id actual*/
                preenche_funcionario_zona: LOOP
                    
					/*ID DE FUNCIONARIO ACTUAL*/
					SET _id_funcionario = (SELECT id FROM funcionario
					WHERE residencia LIKE CONCAT((SELECT nome FROM zona WHERE nome = ANY (SELECT LEFT(residencia, length(residencia)-8)
					FROM funcionario) LIMIT i, 1), '%') LIMIT j, 1);
                    SET j = j+1;
                    IF _id_funcionario IS NOT NULL THEN
						/*Introduzir id de funcionario actual e zona actual na tabela zona_funcionario*/
						INSERT INTO funcionario_residencia(quarteirao, id_funcionario, id_zona)
						VALUES (01, _id_funcionario, _id_zona);
                        ITERATE preenche_funcionario_zona;
					ELSE
						LEAVE preenche_funcionario_zona;
					END IF;
				END LOOP preenche_funcionario_zona;
				
                SET i = i+1;
                IF _id_zona IS NOT NULL THEN
                    ITERATE pega_zona;
				ELSE
					LEAVE pega_zona;
				END IF;
		END LOOP pega_zona;
				
    END; $$

DELIMITER ;

CALL migrar_residencia();

ALTER TABLE funcionario
DROP COLUMN residencia;

DROP TABLE IF EXISTS funcionario_logs;
CREATE TABLE IF NOT EXISTS funcionario_logs(
	id BIGINT NOT NULL AUTO_INCREMENT,
    login TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    logout TIMESTAMP,
    conta_funcionario_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(conta_funcionario_id) REFERENCES contafuncionario(id)
);

SET FOREIGN_KEY_CHECKS = 1;