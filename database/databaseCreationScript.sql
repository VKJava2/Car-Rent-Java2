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


-- -------------------------------------------------------------------------
-- Новая таблица 'vehicles'. Т.к. решили хранить всю технику в одной таблице
-- -------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `car_rent`.`vehicles` (
  `CarID` INT(11) NOT NULL AUTO_INCREMENT,
  `VehicleType` CHAR(32) NOT NULL,
  `Make` CHAR(32) NOT NULL,
  `Model` CHAR(32) NOT NULL,
  `ProductionYear` INT(4) NOT NULL,
  `EngineCapacity` DECIMAL(2,1) NOT NULL,
  `FuelType` CHAR(32) NOT NULL,
  `FuelConsumption` DECIMAL(3,1) NOT NULL,
  `RentPrice` DECIMAL(6,2) NOT NULL,
  `IsAvailable` BOOL NOT NULL,
  `EngineTypeByStrokes` CHAR(32),
  `DriveType` CHAR(32),
  `MotorcycleType` CHAR(32),
  `LuxuryType` CHAR(32),
  `NumberOfDoors` CHAR(32),
  `BodyType` CHAR(32),
  PRIMARY KEY (`CarID`)
);

-- -------------------------------------------------------------------------
-- Пример создания записей нескольких моцаков
-- -------------------------------------------------------------------------

insert into VEHICLES
(CarID, VehicleType, Make, Model, ProductionYear, EngineCapacity, FuelType, FuelConsumption, RentPrice, IsAvailable, EngineTypeByStrokes, DriveType, MotorcycleType)
values
  ('1', 'Motorcycle', 'Honda', 'CB600F Hornet', '2007', '0.6', 'Бензин', '6', '60', '1', '4-тактный', 'Цепь', 'Street'),
  ('2', 'Motorcycle', 'Harley-Davidson', 'Dyna', '2009', '1.7', 'Бензин', '5.6', '90', '1', '2-тактный', 'Ремень', 'Chopper'),
  ('3', 'Motorcycle', 'Yamaha', 'XVZ1300A', '2001', '1.3', 'Бензин', '7', '75', '1', '4-тактный', 'Кардан', 'Cruiser');

insert into VEHICLES
(VehicleType, Make, Model, ProductionYear, EngineCapacity, FuelType, FuelConsumption, RentPrice, IsAvailable, LuxuryType, NumberOfDoors, BodyType)
values
  ('PersonalCar', 'Mercedes', 'C200', '2008', '2.0', 'Diesel', '10', '45', '1', 'Lux', '5', 'Sedan'),
  ('PersonalCar', 'Toyota', 'RAV-4', '2009', '1.9', 'Fuel', '8.6', '50', '1', 'SUV', '5', 'SUV'),
  ('PersonalCar', 'Volvo', 'V80', '2011', '1.8', 'Petrol', '7', '60', '1', 'Family', '5', 'Universal');