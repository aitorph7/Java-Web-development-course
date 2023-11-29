CREATE TABLE `demo1`.`customers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `nif` VARCHAR(9) NULL,
  `age` INT NULL,
  `salary` DECIMAL(14,2) NULL,
  `active` TINYINT(1) NULL,
  `birthday` DATE NULL,
  `biography` TEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nif_UNIQUE` (`nif` ASC) VISIBLE);
