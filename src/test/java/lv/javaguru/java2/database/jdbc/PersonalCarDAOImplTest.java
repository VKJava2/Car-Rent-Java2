package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.PersonalCar;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)

public class PersonalCarDAOImplTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private PersonalCarDAOImpl personalCarDAOImpl = new PersonalCarDAOImpl();

    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    private PersonalCar createPersonalCar(String vehicleType, String image, String make, String model, int productionYear, double engineCapacity, String fuelType, double fuelConsumption,
                                          double rentPrice, boolean isAvailable, String luxuryType, String numberOfDoors, String bodyType) {
        PersonalCar personalCar = new PersonalCar();
        personalCar.setVehicleType(vehicleType);
        personalCar.setImage(image);
        personalCar.setMake(make);
        personalCar.setModel(model);
        personalCar.setProductionYear(productionYear);
        personalCar.setEngineCapacity(engineCapacity);
        personalCar.setFuelType(fuelType);
        personalCar.setFuelConsumption(fuelConsumption);
        personalCar.setRentPrice(rentPrice);
        personalCar.setIsAvailable(isAvailable);
        personalCar.setLuxuryType(luxuryType);
        personalCar.setNumberOfDoors(numberOfDoors);
        personalCar.setBodyType(bodyType);
        return personalCar;
    }

    @Test
    public void testCreate() throws DBException {
        PersonalCar personalCar = createPersonalCar("PersonalCar", "Mercedes Benz", "mercedes_c200_2014.jpg", "190", 1981, 1.9, "Diesel", 8.5, 25, true, "Economy", "5", "Sedan");
        PersonalCar personalCar2 = createPersonalCar("PersonalCar", "Toyota", "toyota_rav4_2014.jpg", "Carola", 1985, 1.6, "Petrol", 7.5, 25, true, "Economy", "5", "Hatchback");

        personalCarDAOImpl.create(personalCar);
        personalCarDAOImpl.create(personalCar2);

        List<PersonalCar> listOfCars = personalCarDAOImpl.getByMake(personalCar.getMake());
        assertNotNull(listOfCars);
        assertEquals(personalCar.getCarId(), listOfCars.get(0).getCarId());
        assertEquals(personalCar.getVehicleType(), listOfCars.get(0).getVehicleType());
        assertEquals(personalCar.getImage(), listOfCars.get(0).getImage());
        assertEquals(personalCar.getMake(), listOfCars.get(0).getMake());
        assertEquals(personalCar.getModel(), listOfCars.get(0).getModel());
        assertEquals(personalCar.getProductionYear(), listOfCars.get(0).getProductionYear());
        assertEquals(personalCar.getEngineCapacity(), listOfCars.get(0).getEngineCapacity(), 0.0);
        assertEquals(personalCar.getFuelType(), listOfCars.get(0).getFuelType());
        assertEquals(personalCar.getFuelConsumption(), listOfCars.get(0).getFuelConsumption(), 0.0);
        assertEquals(personalCar.getRentPrice(), listOfCars.get(0).getRentPrice(), 0.0);
        assertEquals(personalCar.isAvailable(), listOfCars.get(0).isAvailable());
        assertEquals(personalCar.getLuxuryType(), listOfCars.get(0).getLuxuryType());
        assertEquals(personalCar.getNumberOfDoors(), listOfCars.get(0).getNumberOfDoors());
        assertEquals(personalCar.getBodyType(), listOfCars.get(0).getBodyType());

    }

    @Test
    public void testGetAll() throws DBException {
        PersonalCar personalCar = createPersonalCar("PersonalCar", "Mercedes Benz", "mercedes_c200_2014.jpg", "190", 1981, 1.9, "Diesel", 8.5, 25, true, "Economy", "5", "Sedan");
        PersonalCar personalCar2 = createPersonalCar("PersonalCar", "Toyota", "mercedes_c200_2012.jpg", "Carola", 1985, 1.6, "Petrol", 7.5, 25, true, "Economy", "5", "Hatchback");
        PersonalCar personalCarFake = createPersonalCar("Car", "Honda", "mercedes_c200_2011.jpg", "Civic", 2007, 0.6, "Petrol", 6, 60, true, "Urban", "3", "Sedan");
        personalCarDAOImpl.create(personalCar);
        personalCarDAOImpl.create(personalCar2);

        List<PersonalCar> listOfCars = personalCarDAOImpl.getAll();
        assertNotNull(listOfCars);
        assertEquals(2, listOfCars.size());
    }

    @Test
    public void testGetByFuelType() throws DBException {
        PersonalCar personalCar = createPersonalCar("PersonalCar", "Mercedes Benz", "mercedes_c200_2014.jpg", "190", 1981, 1.9, "Diesel", 8.5, 25, true, "Economy", "5", "Sedan");
        PersonalCar personalCar2 = createPersonalCar("PersonalCar", "Toyota", "mercedes_c200_2012.jpg", "Carola", 1985, 1.6, "Petrol", 7.5, 25, true, "Economy", "5", "Hatchback");
        PersonalCar personalCar3 = createPersonalCar("PersonalCar", "Honda", "mercedes_c200_2013.jpg", "Civic", 2007, 0.6, "Petrol", 6, 60, true, "Urban", "3", "Sedan");
        personalCarDAOImpl.create(personalCar);
        personalCarDAOImpl.create(personalCar2);
        personalCarDAOImpl.create(personalCar3);

        List<PersonalCar> listOfCars = personalCarDAOImpl.getByFuelType("Petrol");
        assertNotNull(listOfCars);
        assertEquals(2, listOfCars.size());
    }
}
