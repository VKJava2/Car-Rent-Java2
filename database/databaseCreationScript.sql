SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `car_rent` DEFAULT CHARACTER SET utf8 ;
USE `car_rent` ;

-- -----------------------------------------------------
-- Table `Java2_test`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `car_rent`.`users` ;

CREATE TABLE IF NOT EXISTS `car_rent`.`users` (
  `UserID` INT(11) NOT NULL AUTO_INCREMENT,
  `FirstName` CHAR(32) NOT NULL,
  `LastName` CHAR(32) NOT NULL,
  PRIMARY KEY (`UserID`)
);

CREATE TABLE IF NOT EXISTS `car_rent`.`cars` (
  `CarID` INT(11) NOT NULL AUTO_INCREMENT,
  `Make` CHAR(32) NOT NULL,
  `Model` CHAR(32) NOT NULL,
  `ProductionYear` INT(4) NOT NULL,
  `EngineCapacity` DECIMAL(2,1) NOT NULL,
  PRIMARY KEY (`CarID`)
)

ENGINE = InnoDB
AUTO_INCREMENT = 1002;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Table `Java2_test`.`cars`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `car_rent`.`cars` ;

CREATE TABLE IF NOT EXISTS `car_rent`.`cars` (
  `CarID` INT(11) NOT NULL AUTO_INCREMENT,
  `CarName` CHAR(50) NOT NULL,
  `LicenceNum` CHAR(20) NOT NULL,
  `TechInspection` ENUM('0','1') NOT NULL,
  `TechInspExpire` DATE NOT NULL,
  `FreeToRent` ENUM('0','1') NOT NULL,
  `EngineNum` CHAR(32) NOT NULL,
  `ChassisNum` CHAR(32) NOT NULL,
  `Insured` ENUM('0','1') NOT NULL,
  `InsuranceExpire` DATE NOT NULL,
  PRIMARY KEY (`CarID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1002;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Insert one row into Table 'cars'
-- -----------------------------------------------------

INSERT INTO cars (`CarName`,`LicenceNum`,`TechInspection`,`TechInspExpire`,`FreeToRent`,`EngineNum`,`ChassisNum`,`Insured`,`InsuranceExpire`) VALUES ('Mercedes C200','CD3789','1','2016-09-15','1','23123123123135','fdsfdfsdf31312','1','2016-08-13');
