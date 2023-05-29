SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `Admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Admin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `content` VARCHAR(500) NOT NULL,
  `likesQuantity` INT NOT NULL,
  `deslikesQuantity` INT NOT NULL,
  `date` DATETIME NOT NULL,
  `Admin_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Admin_id`),
  INDEX `fk_Post_Admin_idx` (`Admin_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Rating` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `User_id` INT NOT NULL,
  `Post_id` INT NOT NULL,
  `isLiked` TINYINT NOT NULL,
  PRIMARY KEY (`id`, `User_id`, `Post_id`),
  INDEX `fk_Rating_User1_idx` (`User_id` ASC) VISIBLE,
  INDEX `fk_Rating_Post1_idx` (`Post_id` ASC) VISIBLE,
  CONSTRAINT `fk_Rating_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rating_Post1`
    FOREIGN KEY (`Post_id`)
    REFERENCES `Post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
