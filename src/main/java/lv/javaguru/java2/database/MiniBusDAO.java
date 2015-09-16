package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.MiniBus;

import java.util.List;
import java.util.Map;

/**
 * Created by XidenT on 01/08/2015.
 */
public interface MiniBusDAO {

    void create(MiniBus miniBus) throws DBException;
    MiniBus getById(String id) throws DBException;
    void delete(Long id) throws DBException;
    List<MiniBus> getAll() throws DBException;
    Map<String, String> getSpecials(String id) throws DBException;
}
