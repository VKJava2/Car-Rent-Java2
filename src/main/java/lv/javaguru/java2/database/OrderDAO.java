package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Order;

import java.util.List;

/**
 * Created by VK on 2015.07.22..
 */

public interface OrderDAO {
    String create(Order order) throws DBException;
    Order getById(String id) throws DBException;
    List<Order> getAll() throws DBException;
    void delete(Order order) throws DBException;
}
