package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.OrderDAO;
import lv.javaguru.java2.domain.Order;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VK on 2015.07.22..
 */

@Component
public class OrderDAOImpl extends DAOImpl implements OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public String create(Order order) throws DBException {
        long orderIdL = (Long)sessionFactory.getCurrentSession().save(order);
        String orderIdS = Long.toString(orderIdL);
        return orderIdS;
    }

    public Order getById(String id) throws DBException {
        Order order;
        Long orderId = Long.valueOf(id);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);
        criteria.add(Restrictions.eq("orderId", orderId));
        return order = (Order) criteria.uniqueResult();
    }

    public List<Order> getAll() throws DBException {
        List<Order> orders = new ArrayList<Order>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);
        return orders = (List<Order>) criteria.list();
    }

    public void delete(Order order) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);
        sessionFactory.getCurrentSession().delete(order);
    }
}