package lv.javaguru.java2.database.jdbc;

import static org.junit.Assert.*;

import lv.javaguru.java2.domain.Car;
import org.junit.Before;
import org.junit.Test;

import lv.javaguru.java2.database.DBException;

/**
 * Created by VK on 2015.07.22..
 */
public class CarDAOImplTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private CarDAOImpl carDAOImpl = new CarDAOImpl();

    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        Car car = createCar("Ford", "Focus", 2007, 1.6);

        carDAOImpl.create(car);

        Car carFromDB = carDAOImpl.getByMake(car.getMake());
        assertNotNull(carFromDB);
        assertEquals(car.getCarId(), carFromDB.getCarId());
        assertEquals(car.getMake(), carFromDB.getMake());
        assertEquals(car.getModel(), carFromDB.getModel());
        assertEquals(car.getProductionYear(), carFromDB.getProductionYear());
        assertEquals(car.getEngineCapacity(), carFromDB.getEngineCapacity(), 0.0);
    }

/*    @Test
    public void testMultipleCarCreation() throws DBException {
        Car car1 = createCar("Ford", "Focus", 2007, 1.6);
        Car car2 = createCar("Opel", "Astra", 2006, 1.7);
        carDAOImpl.create(car1);
        carDAOImpl.create(car2);
        List<Car> cars = carDAOImpl.getAll();
        assertEquals(2, cars.size());
    }   */

    private Car createCar(String make, String model, int productionYear, double engineCapacity) {
        Car car = new Car();
        car.setMake(make);
        car.setModel(model);
        car.setProductionYear(productionYear);
        car.setEngineCapacity(engineCapacity);
        return car;
    }
}
