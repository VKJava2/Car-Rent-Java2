package lv.javaguru.java2.database;


import lv.javaguru.java2.domain.PersonalCar;

import java.util.ArrayList;
import java.util.List;

public interface PersonalCarDAO {

    void create(PersonalCar personalCar) throws DBException;

    PersonalCar getById(String id) throws DBException; // 1 car

    List<PersonalCar> getByMake(String manufacturer) throws DBException; // one or many = List

    List<PersonalCar> getByLuxuryType(String luxuryType) throws DBException; // one or many = List

    List<PersonalCar> getByBodyType(String bodyType) throws DBException; // one or many = List

    List<PersonalCar> getByFuelType(String fuelType) throws DBException; // one or many = List

    void delete(Long id) throws DBException;

    List<PersonalCar> getAll() throws DBException;
}
