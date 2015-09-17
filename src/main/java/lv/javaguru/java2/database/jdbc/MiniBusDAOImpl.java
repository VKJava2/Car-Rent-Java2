package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.MiniBusDAO;
import lv.javaguru.java2.domain.MiniBus;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XidenT on 02/08/2015.
 */

@Component
public class MiniBusDAOImpl extends DAOImpl implements MiniBusDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void create(MiniBus miniBus) throws DBException {
        sessionFactory.getCurrentSession().save(miniBus);
    }

    public MiniBus getById(String id) throws DBException {
        MiniBus miniBus;
        Long carId = Long.valueOf(id);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MiniBus.class);
        criteria.add(Restrictions.eq("carId", carId));
        return miniBus = (MiniBus) criteria.uniqueResult();
    }

    public void delete(Long id) throws DBException {
        MiniBus miniBus;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MiniBus.class);
        criteria.add(Restrictions.eq("carId", id));
        miniBus = (MiniBus) criteria.uniqueResult();
        sessionFactory.getCurrentSession().delete(miniBus);
    }

    public List<MiniBus> getAll() throws DBException {
        List<MiniBus> miniBus = new ArrayList<MiniBus>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MiniBus.class);
        criteria.add(Restrictions.eq("vehicleType", "MiniBus"));
        return miniBus = (List<MiniBus>) criteria.list();
    }

    public Map<String, String> getSpecials(String id) throws DBException {
        MiniBus miniBus;
        Long carId = Long.valueOf(id);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MiniBus.class);
        criteria.add(Restrictions.eq("carId", carId));
        miniBus = (MiniBus) criteria.uniqueResult();
        Map<String, String> typeSpecials = new HashMap<String, String>();
        typeSpecials.put("Minibus seats", Integer.toString(miniBus.getSeatNumber()));
        typeSpecials.put("Cargo volume", Double.toString(miniBus.getCargoVolume()));
        typeSpecials.put("Minibus color", miniBus.getMiniBusColor());
        return typeSpecials;
    }

}

