CREATE TABLE IF NOT EXISTS `ProjetoIntegrado`.`tb_usuarios` (
  `idtb_usuarios` INT NOT NULL AUTO_INCREMENT,
  `name_usuario` VARCHAR(45) NOT NULL,
  `fone_usuario` VARCHAR(15) NULL,
  `login_usuario` VARCHAR(15) NOT NULL,
  `senha_usuario` VARCHAR(255) NOT NULL,
  `perfil` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtb_usuarios`),
  UNIQUE INDEX `login_usuario_UNIQUE` (`login_usuario`));
  
  CREATE TABLE IF NOT EXISTS `ProjetoIntegrado`.`tb_produtos` (
  `idtb_produtos` INT NOT NULL AUTO_INCREMENT,
  `descricao_produtos` VARCHAR(70) NOT NULL,
  `marca_produtos` VARCHAR(80) NOT NULL,
  `preco_produtos` DOUBLE NOT NULL,
  `caracteristica_produtos` VARCHAR(100) NULL,
  `estoque_produtos` INT NOT NULL,
  PRIMARY KEY (`idtb_produtos`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `ProjetoIntegrado`.`tb_vendas` (
  `idtb_vendas` INT NOT NULL AUTO_INCREMENT,
  `descricao_vendas` VARCHAR(70) NOT NULL,
  `quantidade_vendas` INT NOT NULL,
  `precoItem_vendas` DOUBLE NOT NULL,
  `total_vendas` DOUBLE NOT NULL,
  `tb_produtos_idtb_produtos` INT NOT NULL,
  PRIMARY KEY (`idtb_vendas`),
  UNIQUE INDEX `idtb_vendas_UNIQUE` (`idtb_vendas` ),
  INDEX `fk_tb_vendas_tb_produtos_idx` (`tb_produtos_idtb_produtos` ),
  CONSTRAINT `fk_tb_vendas_tb_produtos`
    FOREIGN KEY (`tb_produtos_idtb_produtos`)
    REFERENCES `ProjetoIntegrado`.`tb_produtos` (`idtb_produtos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO tb_usuarios ( name_usuario,fone_usuario,login_usuario,senha_usuario,perfil)
VALUES ('Matheus','12996605297','Teste','123','Administrador');

INSERT INTO tb_produtos (descricao_produtos, marca_produtos, preco_produtos, caracteristica_produtos, estoque_produtos)
VALUES ('Iphone 7 Usado 32 gb', 'Iphone', 1200, 'Usado', 12);
SELECT * FROM tb_produtos;

SELECT * FROM tb_produtos WHERE  idtb_produtos = 1;

SELECT * FROM tb_produtos WHERE descricao_produtos = "Xbox";

select * from tb_usuarios;

UPDATE tb_produtos SET  descricao_produtos = 'Computador',preco_produtos = '1230' WHERE idtb_produtos =2 ;


CREATE TABLE IF NOT EXISTS `ProjetoIntegrado`.`tb_vendas` (
  `idtb_vendas` INT NOT NULL AUTO_INCREMENT,
  `quantidade_vendas` INT NOT NULL,
  `precoItem_vendas` DOUBLE UNSIGNED NOT NULL,
  `total_vendas` DOUBLE UNSIGNED NOT NULL,
  `tb_produtos_idtb_produtos` INT NOT NULL,
  PRIMARY KEY (`idtb_vendas`),
  UNIQUE INDEX `idtb_vendas_UNIQUE` (`idtb_vendas` ),
  INDEX `fk_tb_vendas_tb_produtos_idx` (`tb_produtos_idtb_produtos` ),
  CONSTRAINT `fk_tb_vendas_tb_produtos`
    FOREIGN KEY (`tb_produtos_idtb_produtos`)
    REFERENCES `ProjetoIntegrado`.`tb_produtos` (`idtb_produtos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO tb_vendas (quantidade_vendas, precoItem_vendas, total_vendas,tb_produtos_idtb_produtos) 
VALUES ( 15, 50, 12, 1);

SELECT * FROM tb_vendas;

SELECT idtb_vendas, quantidade_vendas, descricao_produtos, preco_produtos FROM tb_vendas INNER JOIN tb_produtos ON idtb_produtos = 13;

SELECT idtb_vendas, quantidade_vendas,total_vendas, descricao_produtos, preco_produtos, pk_idtbProdutos FROM tb_vendas LEFT JOIN tb_produtos on idtb_produtos = pk_idtbProdutos; 

SELECT descricao_produtos FROM tb_produtos where descricao_produtos like 'p%%';

drop table tb_vendas;
CREATE TABLE IF NOT EXISTS `ProjetoIntegrado`.`tb_vendas` (
  `idtb_vendas` INT NOT NULL AUTO_INCREMENT,
  `quantidade_vendas` INT NOT NULL,
  `total_vendas` DOUBLE UNSIGNED NOT NULL,
  `tb_produtos_idtb_produtos` INT NOT NULL,
  PRIMARY KEY (`idtb_vendas`),
  UNIQUE INDEX `idtb_vendas_UNIQUE` (`idtb_vendas` ASC),
  INDEX `fk_tb_vendas_tb_produtos_idx` (`tb_produtos_idtb_produtos` ASC),
  CONSTRAINT `fk_tb_vendas_tb_produtos`
    FOREIGN KEY (`tb_produtos_idtb_produtos`)
    REFERENCES `ProjetoIntegrado`.`tb_produtos` (`idtb_produtos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO tb_vendas (quantidade_vendas,total_vendas,pk_idtbProdutos)
VALUES (1123.4,1,14);

SELECT * FROM tb_vendas;

DROP TABLE tb_vendas;


CREATE TABLE IF NOT EXISTS `ProjetoIntegrado`.`tb_vendas` (
  `idtb_vendas` INT NOT NULL AUTO_INCREMENT,
  `quantidade_vendas` INT NOT NULL,
  `total_vendas` DOUBLE NOT NULL,
  `pk_idtbProdutos` INT NOT NULL,
  PRIMARY KEY (`idtb_vendas`),
  UNIQUE INDEX `idtb_vendas_UNIQUE` (`idtb_vendas` ASC) ,
  INDEX `fk_tb_vendas_tb_produtos_idx` (`pk_idtbProdutos` ASC) ,
  CONSTRAINT `fk_tb_vendas_tb_produtos`
    FOREIGN KEY (`pk_idtbProdutos`)
    REFERENCES `ProjetoIntegrado`.`tb_produtos` (`idtb_produtos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;




