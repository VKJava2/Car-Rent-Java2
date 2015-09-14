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
import java.util.List;

@Component
public class PersonalCarDAOImpl extends DAOImpl implements PersonalCarDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void create(PersonalCar personalCar) throws DBException {
        sessionFactory.getCurrentSession().save(personalCar);

    }

    public PersonalCar getById(String carID) throws DBException {
        PersonalCar personalCar;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PersonalCar.class);
        criteria.add(Restrictions.eq("carId", carID));
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
}
