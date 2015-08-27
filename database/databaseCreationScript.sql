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
-- ����� ������� 'vehicles'. �.�. ������ ������� ��� ������� � ����� �������
-- -------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `car_rent`.`vehicles` (
  `CarID` INT(11) NOT NULL AUTO_INCREMENT,
  `VehicleType` CHAR(32) NOT NULL,
  `Image` CHAR(50) NOT NULL,
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
-- ������ �������� ������� ���������� �������
-- -------------------------------------------------------------------------

insert into VEHICLES
(VehicleType, Image, Make, Model, ProductionYear, EngineCapacity, FuelType, FuelConsumption, RentPrice, IsAvailable, EngineTypeByStrokes, DriveType, MotorcycleType)
values
  ('Motorcycle', 'empty', 'Honda', 'CB600F Hornet', '2007', '0.6', '������', '6', '60', '1', '4-�������', '����', 'Street'),
  ('Motorcycle', 'empty', 'Harley-Davidson', 'Dyna', '2009', '1.7', '������', '5.6', '90', '1', '2-�������', '������', 'Chopper'),
  ('Motorcycle', 'empty', 'Yamaha', 'XVZ1300A', '2001', '1.3', '������', '7', '75', '1', '4-�������', '������', 'Cruiser');

insert into VEHICLES
(VehicleType, Image, Make, Model, ProductionYear, EngineCapacity, FuelType, FuelConsumption, RentPrice, IsAvailable, LuxuryType, NumberOfDoors, BodyType)
values
  ('PersonalCar', 'mercedes_c200_2014.jpg', 'Mercedes', 'C200', '2014', '2.0', 'Diesel', '10', '45', '1', 'Lux', '5', 'Sedan'),
  ('PersonalCar', 'toyota_rav4_2014.jpg', 'Toyota', 'RAV-4', '2013', '1.9', 'Fuel', '8.6', '50', '1', 'SUV', '5', 'SUV'),
  ('PersonalCar', 'volvo_S80_2014.jpg', 'Volvo', 'S80', '2014', '1.8', 'Petrol', '7', '60', '1', 'Lux', '5', 'Sedan'),
  ('PersonalCar', 'mercedes_e180_2014.jpg', 'Mercedes', 'E180', '2010', '2.0', 'Diesel', '7.3', '60', '1', 'Lux', '5', 'Sedan'),
  ('PersonalCar', 'volvo_v60_2008.jpg', 'Volvo', 'V60', '2009', '1.6', 'Petrol', '5.5', '50', '1', 'Family', '5', 'Universal');