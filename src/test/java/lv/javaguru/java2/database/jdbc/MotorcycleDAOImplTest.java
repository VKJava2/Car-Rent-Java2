package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Motorcycle;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by VK on 2015.07.22..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)

public class MotorcycleDAOImplTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private MotorcycleDAOImpl motorcycleDAOImpl = new MotorcycleDAOImpl();

    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        Motorcycle motorcycle = createMotorcycle("Motorcycle", "toyota_rav4_2014.jpg", "Honda", "CB600F Hornet", 2007, 0.6, "Бензин", 6, 60, true, "4-тактный", "Цепь", "Street");
        Motorcycle motorcycle2 = createMotorcycle("Car", "toyota_rav4_2014.jpg", "Honda", "CB600F Hornet", 2007, 0.6, "Бензин", 6, 60, true, "4-тактный", "Цепь", "Street");

        motorcycleDAOImpl.create(motorcycle);
        motorcycleDAOImpl.create(motorcycle2);

        Motorcycle motorcycleFromDB = motorcycleDAOImpl.getByMake(motorcycle.getMake());
        assertNotNull(motorcycleFromDB);
        assertEquals(motorcycle.getCarId(), motorcycleFromDB.getCarId());
        assertEquals(motorcycle.getVehicleType(), motorcycleFromDB.getVehicleType());
        assertEquals(motorcycle.getImage(), motorcycleFromDB.getImage());
        assertEquals(motorcycle.getMake(), motorcycleFromDB.getMake());
        assertEquals(motorcycle.getModel(), motorcycleFromDB.getModel());
        assertEquals(motorcycle.getProductionYear(), motorcycleFromDB.getProductionYear());
        assertEquals(motorcycle.getEngineCapacity(), motorcycleFromDB.getEngineCapacity(), 0.0);
        assertEquals(motorcycle.getFuelType(), motorcycleFromDB.getFuelType());
        assertEquals(motorcycle.getFuelConsumption(), motorcycleFromDB.getFuelConsumption(), 0.0);
        assertEquals(motorcycle.getRentPrice(), motorcycleFromDB.getRentPrice(), 0.0);
        assertEquals(motorcycle.isAvailable(), motorcycleFromDB.isAvailable());
        assertEquals(motorcycle.getEngineTypeByStrokes(), motorcycleFromDB.getEngineTypeByStrokes());
        assertEquals(motorcycle.getDriveType(), motorcycleFromDB.getDriveType());
        assertEquals(motorcycle.getMotorcycleType(), motorcycleFromDB.getMotorcycleType());
    }

    @Test
    public void testMultipleCarCreation() throws DBException {
        Motorcycle motorcycle = createMotorcycle("Motorcycle", "toyota_rav4_2014.jpg", "Honda", "CB600F Hornet", 2007, 0.6, "Бензин", 6, 60, true, "4-тактный", "Цепь", "Street");
        Motorcycle motorcycle2 = createMotorcycle("Car", "toyota_rav4_2014.jpg", "Honda", "CB600F Hornet", 2007, 0.6, "Бензин", 6, 60, true, "4-тактный", "Цепь", "Street");
        Motorcycle motorcycle3 = createMotorcycle("Motorcycle", "toyota_rav4_2014.jpg", "Suzuki", "SV", 2006, 0.6, "Бензин", 5.5, 50, true, "2-тактный", "Цепь", "Street");
        motorcycleDAOImpl.create(motorcycle);
        motorcycleDAOImpl.create(motorcycle2);
        motorcycleDAOImpl.create(motorcycle3);
        List<Motorcycle> motorcycles = motorcycleDAOImpl.getAll();
        assertEquals(2, motorcycles.size());
    }

    private Motorcycle createMotorcycle(String vehicleType, String image, String make, String model, int productionYear, double engineCapacity, String fuelType, double fuelConsumption,
                                        double rentPrice, boolean isAvailable, String engineTypeByStrokes, String driveType, String motorcycleType) {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setVehicleType(vehicleType);
        motorcycle.setImage(image);
        motorcycle.setMake(make);
        motorcycle.setModel(model);
        motorcycle.setProductionYear(productionYear);
        motorcycle.setEngineCapacity(engineCapacity);
        motorcycle.setFuelType(fuelType);
        motorcycle.setFuelConsumption(fuelConsumption);
        motorcycle.setRentPrice(rentPrice);
        motorcycle.setIsAvailable(isAvailable);
        motorcycle.setEngineTypeByStrokes(engineTypeByStrokes);
        motorcycle.setDriveType(driveType);
        motorcycle.setMotorcycleType(motorcycleType);
        return motorcycle;
    }
}
