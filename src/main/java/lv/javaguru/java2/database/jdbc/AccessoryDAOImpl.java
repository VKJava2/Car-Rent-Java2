package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.AccessoryDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Accessory;
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
public class AccessoryDAOImpl extends DAOImpl implements AccessoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Accessory getById(String id) throws DBException {
        Accessory accessory;
        Long accessoryId = Long.valueOf(id);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Accessory.class);
        criteria.add(Restrictions.eq("accessoryId", accessoryId));
        return accessory = (Accessory) criteria.uniqueResult();
    }

    public List<Accessory> getAll(String availableFor) throws DBException {
        List<Accessory> accessories = new ArrayList<Accessory>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Accessory.class);
        criteria.add(Restrictions.eq("availableFor", availableFor));
        return accessories = (List<Accessory>) criteria.list();
    }
}