package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.PersonalCarDAO;
import lv.javaguru.java2.domain.PersonalCar;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PersonalCarDAOImpl extends DAOImpl implements PersonalCarDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void create(PersonalCar personalCar) throws DBException {
        sessionFactory.getCurrentSession().save(personalCar);

    }

    public PersonalCar getById(String id) throws DBException {
        PersonalCar personalCar;
        Long carId = Long.valueOf(id);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PersonalCar.class);
        criteria.add(Restrictions.eq("carId", carId));
        return personalCar = (PersonalCar) criteria.uniqueResult();
    }

    public List<PersonalCar> getByMake(String manufacturer) throws DBException {
        List<PersonalCar> personalCars = new ArrayList<PersonalCar>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PersonalCar.class);
        criteria.add(Restrictions.eq("vehicleType", "PersonalCar"));
        criteria.add(Restrictions.eq("make", manufacturer));
        return personalCars = (List<PersonalCar>) criteria.list();
    }

    public List<PersonalCar> getByLuxuryType(String luxuryType) throws DBException {
        List<PersonalCar> personalCars = new ArrayList<PersonalCar>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PersonalCar.class);
        criteria.add(Restrictions.eq("luxuryType", luxuryType));
        return personalCars = (List<PersonalCar>) criteria.list();
    }

    public List<PersonalCar> getByBodyType(String bodyType) throws DBException {
        List<PersonalCar> personalCars = new ArrayList<PersonalCar>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PersonalCar.class);
        criteria.add(Restrictions.eq("bodyType", bodyType));
        return personalCars = (List<PersonalCar>) criteria.list();
    }

    public List<PersonalCar> getByFuelType(String fuelType) throws DBException {
        List<PersonalCar> personalCars = new ArrayList<PersonalCar>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PersonalCar.class);
        criteria.add(Restrictions.eq("vehicleType", "PersonalCar"));
        criteria.add(Restrictions.eq("fuelType", fuelType));
        return personalCars = (List<PersonalCar>) criteria.list();
    }

    public List<PersonalCar> getAll() throws DBException {
        List<PersonalCar> personalCars = new ArrayList<PersonalCar>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PersonalCar.class);
        criteria.add(Restrictions.eq("vehicleType", "PersonalCar"));
        return personalCars = (List<PersonalCar>) criteria.list();
    }

    public void delete(Long id) throws DBException {
        PersonalCar personalCar;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PersonalCar.class);
        criteria.add(Restrictions.eq("carId", id));
        personalCar = (PersonalCar) criteria.uniqueResult();
        sessionFactory.getCurrentSession().delete(personalCar);
    }
    public Map<String, String> getSpecials(String id) throws DBException {
        PersonalCar personalCar;
        Long carId = Long.valueOf(id);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PersonalCar.class);
        criteria.add(Restrictions.eq("carId", carId));
        personalCar = (PersonalCar) criteria.uniqueResult();
        Map<String, String> typeSpecials = new HashMap<String, String>();
        typeSpecials.put("Luxury type", personalCar.getLuxuryType());
        typeSpecials.put("Number of doors", personalCar.getNumberOfDoors());
        typeSpecials.put("Body type", personalCar.getBodyType());
        return typeSpecials;
    }
}
