package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Motorcycle;

import java.util.List;

/**
 * Created by VK on 2015.07.22..
 */

public interface MotorcycleDAO {

    void create(Motorcycle motorcycle) throws DBException;
    List<Motorcycle> getByMake(String make) throws DBException;
    Motorcycle getById(String id) throws DBException;
    List<Motorcycle> getAll() throws DBException;

}
