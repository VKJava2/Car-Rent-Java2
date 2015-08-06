package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Car;

import java.util.List;

/**
 * Created by VK on 2015.07.22..
 */

public interface CarDAO {

    void create(Car car) throws DBException;
    Car getByMake(String make) throws DBException;
    void delete(Long id) throws DBException;
    void update(Car car) throws DBException;
    List<Car> getAll() throws DBException;

}
