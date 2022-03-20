-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hotel_sunset
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hotel_sunset
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotel_sunset` DEFAULT CHARACTER SET utf8 ;
USE `hotel_sunset` ;

-- -----------------------------------------------------
-- Table `hotel_sunset`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`order` (
  `idorder` INT NOT NULL AUTO_INCREMENT,
  `status` INT NULL DEFAULT 1,
  PRIMARY KEY (`idorder`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`title`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`title` (
  `idtitle` INT NOT NULL AUTO_INCREMENT,
  `title_name` VARCHAR(45) NULL,
  `status` INT NULL DEFAULT 1,
  PRIMARY KEY (`idtitle`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`customer_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`customer_info` (
  `idcustomer_info` INT NOT NULL AUTO_INCREMENT,
  `f_name` VARCHAR(45) NULL,
  `l_name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `nic_number` VARCHAR(45) NULL,
  `nationality` VARCHAR(45) NULL,
  `status` INT NULL DEFAULT 1,
  `title` INT NOT NULL,
  PRIMARY KEY (`idcustomer_info`),
  INDEX `fk_customer_info_title1` (`title` ASC) VISIBLE,
  CONSTRAINT `fk_customer_info_title1`
    FOREIGN KEY (`title`)
    REFERENCES `hotel_sunset`.`title` (`idtitle`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`membership_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`membership_type` (
  `idmembership_type` INT NOT NULL AUTO_INCREMENT,
  `type_name` VARCHAR(45) NULL,
  `status` INT NULL DEFAULT 1,
  PRIMARY KEY (`idmembership_type`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`membership`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`membership` (
  `idmembership` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `valid_from` VARCHAR(45) NULL,
  `valid_until` VARCHAR(45) NULL,
  `status` INT NULL DEFAULT '1',
  `membershipcol` VARCHAR(45) NULL,
  `membership_type` INT NOT NULL,
  PRIMARY KEY (`idmembership`),
  INDEX `fk_membership_membership_type1` (`membership_type` ASC) VISIBLE,
  CONSTRAINT `fk_membership_membership_type1`
    FOREIGN KEY (`membership_type`)
    REFERENCES `hotel_sunset`.`membership_type` (`idmembership_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`room_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`room_info` (
  `idroom_info` INT NOT NULL AUTO_INCREMENT,
  `room_number` VARCHAR(45) NULL,
  `ststus` INT NULL DEFAULT 1,
  PRIMARY KEY (`idroom_info`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`aminities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`aminities` (
  `idaminities` INT NOT NULL AUTO_INCREMENT,
  `aminities_name` VARCHAR(45) NULL,
  `status` INT NULL DEFAULT 1,
  PRIMARY KEY (`idaminities`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`type_of_work`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`type_of_work` (
  `idtype_of_work` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `status` INT NULL DEFAULT 1,
  PRIMARY KEY (`idtype_of_work`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`employee_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`employee_info` (
  `idemployee_info` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `phone_number` INT(10) NULL,
  `address` VARCHAR(45) NULL,
  `dob` VARCHAR(45) NULL,
  `gender` INT NOT NULL,
  `status` INT NULL DEFAULT 1,
  `idtype_of_work` INT NOT NULL,
  PRIMARY KEY (`idemployee_info`),
  INDEX `fk_employee_info_type_of_work1` (`idtype_of_work` ASC) VISIBLE,
  CONSTRAINT `fk_employee_info_type_of_work1`
    FOREIGN KEY (`idtype_of_work`)
    REFERENCES `hotel_sunset`.`type_of_work` (`idtype_of_work`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`attendacne_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`attendacne_type` (
  `idattendacne_type` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `status` INT NULL DEFAULT 1,
  PRIMARY KEY (`idattendacne_type`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`attendance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`attendance` (
  `idattendance` INT NOT NULL AUTO_INCREMENT,
  `date` VARCHAR(45) NULL,
  `time` VARCHAR(45) NULL,
  `status` INT NULL DEFAULT 1,
  `attendacne_type` INT NOT NULL,
  PRIMARY KEY (`idattendance`),
  INDEX `fk_attendance_attendacne_type1` (`attendacne_type` ASC) VISIBLE,
  CONSTRAINT `fk_attendance_attendacne_type1`
    FOREIGN KEY (`attendacne_type`)
    REFERENCES `hotel_sunset`.`attendacne_type` (`idattendacne_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`portion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`portion` (
  `idportion` INT NOT NULL AUTO_INCREMENT,
  `detail` VARCHAR(100) NULL,
  `status` INT NULL DEFAULT 1,
  PRIMARY KEY (`idportion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`food_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`food_type` (
  `idfood_type` INT NOT NULL AUTO_INCREMENT,
  `type_name` VARCHAR(45) NULL,
  `status` INT NULL DEFAULT 1,
  PRIMARY KEY (`idfood_type`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`food_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`food_info` (
  `idfood_info` INT NOT NULL AUTO_INCREMENT,
  `food_description` VARCHAR(200) NULL,
  `price` DOUBLE NULL,
  `image` VARCHAR(200) NULL,
  `status` INT NULL DEFAULT 1,
  `portion` INT NOT NULL,
  `food_type` INT NOT NULL,
  PRIMARY KEY (`idfood_info`),
  INDEX `fk_food_info_portion1` (`portion` ASC) VISIBLE,
  INDEX `fk_food_info_food_type1` (`food_type` ASC) VISIBLE,
  CONSTRAINT `fk_food_info_portion1`
    FOREIGN KEY (`portion`)
    REFERENCES `hotel_sunset`.`portion` (`idportion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_food_info_food_type1`
    FOREIGN KEY (`food_type`)
    REFERENCES `hotel_sunset`.`food_type` (`idfood_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`menu_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`menu_type` (
  `idmenu_type` INT NOT NULL AUTO_INCREMENT,
  `menu_type_name` VARCHAR(45) NULL,
  `status` INT NULL DEFAULT 1,
  PRIMARY KEY (`idmenu_type`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`menu` (
  `idmenu` INT NOT NULL AUTO_INCREMENT,
  `menu_name` VARCHAR(45) NULL,
  `menu_description` VARCHAR(200) NULL,
  `menu_price` DOUBLE NULL,
  `status` INT NULL DEFAULT 1,
  `menu_type` INT NOT NULL,
  PRIMARY KEY (`idmenu`),
  INDEX `fk_menu_menu_type1` (`menu_type` ASC) VISIBLE,
  CONSTRAINT `fk_menu_menu_type1`
    FOREIGN KEY (`menu_type`)
    REFERENCES `hotel_sunset`.`menu_type` (`idmenu_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`food_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`food_table` (
  `idfood_table` INT NOT NULL AUTO_INCREMENT,
  `table_location` VARCHAR(45) NULL,
  `seat_count` INT NULL,
  `status` INT NULL DEFAULT 1,
  PRIMARY KEY (`idfood_table`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_sunset`.`room_info_has_aminities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_sunset`.`room_info_has_aminities` (
  `room_info_idroom_info` INT NOT NULL,
  `aminities_idaminities` INT NOT NULL,
  `room_aminityID` INT NOT NULL AUTO_INCREMENT,
  `status` INT NULL DEFAULT 1,
  PRIMARY KEY (`room_aminityID`),
  INDEX `fk_room_info_has_aminities_aminities1` (`aminities_idaminities` ASC) VISIBLE,
  INDEX `fk_room_info_has_aminities_room_info` (`room_info_idroom_info` ASC) VISIBLE,
  CONSTRAINT `fk_room_info_has_aminities_room_info`
    FOREIGN KEY (`room_info_idroom_info`)
    REFERENCES `hotel_sunset`.`room_info` (`idroom_info`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_room_info_has_aminities_aminities1`
    FOREIGN KEY (`aminities_idaminities`)
    REFERENCES `hotel_sunset`.`aminities` (`idaminities`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
