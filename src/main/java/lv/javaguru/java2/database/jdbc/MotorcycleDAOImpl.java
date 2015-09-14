package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.MotorcycleDAO;
import lv.javaguru.java2.domain.Motorcycle;
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
public class MotorcycleDAOImpl extends DAOImpl implements MotorcycleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void create(Motorcycle motorcycle) throws DBException {
        sessionFactory.getCurrentSession().save(motorcycle);

    }

    public Motorcycle getById(String id) throws DBException {
        Motorcycle motorcycle;
        Long carId = Long.valueOf(id);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Motorcycle.class);
        criteria.add(Restrictions.eq("carId", carId));
        return motorcycle = (Motorcycle) criteria.uniqueResult();
    }

    public List<Motorcycle> getByMake(String make) throws DBException {
        List<Motorcycle> motorcycles = new ArrayList<Motorcycle>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Motorcycle.class);
        criteria.add(Restrictions.eq("vehicleType", "Motorcycle"));
        criteria.add(Restrictions.eq("make", make));
        return motorcycles = (List<Motorcycle>) criteria.list();
    }

    public List<Motorcycle> getAll() throws DBException {
        List<Motorcycle> motorcycles = new ArrayList<Motorcycle>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Motorcycle.class);
        criteria.add(Restrictions.eq("vehicleType", "Motorcycle"));
        return motorcycles = (List<Motorcycle>) criteria.list();
    }
}