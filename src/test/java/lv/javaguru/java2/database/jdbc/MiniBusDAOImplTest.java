package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
//import lv.javaguru.java2.domain.Accessory;
import lv.javaguru.java2.domain.MiniBus;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by XidenT on 02/08/2015.
 */
public class MiniBusDAOImplTest {
    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private MiniBusDAOImpl miniBusDAO = new MiniBusDAOImpl();

    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        MiniBus miniBus = createMiniBus("", "MiniBus", "VW", "Golf", 1985, 2.5, "Diesel", 13.7, 45.00, true, 9, 32.3, "gray");

        miniBusDAO.create(miniBus);

        MiniBus miniBusFromDB = miniBusDAO.getById(miniBus.getCarId());
        assertNotNull(miniBusFromDB);
        assertEquals(miniBus.getCarId(), miniBusFromDB.getCarId());
        assertEquals(miniBus.getImage(), miniBusFromDB.getImage());
        assertEquals(miniBus.getVehicleType(), miniBusFromDB.getVehicleType());
        assertEquals(miniBus.getMake(), miniBusFromDB.getMake());
        assertEquals(miniBus.getModel(), miniBusFromDB.getModel());
        assertEquals(miniBus.getProductionYear(), miniBusFromDB.getProductionYear());
        assertEquals(miniBus.getEngineCapacity(), miniBusFromDB.getEngineCapacity(), 0.1);
        assertEquals(miniBus.getFuelType(), miniBusFromDB.getFuelType());
        assertEquals(miniBus.getFuelConsumption(), miniBusFromDB.getFuelConsumption(), 0.1);
        assertEquals(miniBus.getRentPrice(), miniBusFromDB.getRentPrice(), 0.1);
        assertEquals(miniBus.isAvailable(), miniBusFromDB.isAvailable());
//        assertEquals(miniBus.getAccessories(), miniBusFromDB.getAccessories());
        assertEquals(miniBus.getSeatNumber(), miniBusFromDB.getSeatNumber());
        assertEquals(miniBus.getCargoVolume(), miniBusFromDB.getCargoVolume(), 0.1);
        assertEquals(miniBus.getMiniBusColor(), miniBusFromDB.getMiniBusColor());
    }

    @Test
    public void testMultipleMiniBusCreation() throws DBException {
        MiniBus miniBus1 = createMiniBus("", "MiniBus", "Citroen", "C4", 2006, 1.6, "Gasoline", 5.9, 75.50, true, 7, 21.7, "red");
        MiniBus miniBus2 = createMiniBus("", "MiniBus", "Fiat", "Panda", 2008, 1.4, "Gasoline", 6.8, 70.00, true, 12, 16.4, "black");
        miniBusDAO.create(miniBus1);
        miniBusDAO.create(miniBus2);
        List<MiniBus> miniBuses = miniBusDAO.getAll();
        assertEquals(2, miniBuses.size());
    }

    private MiniBus createMiniBus(String image, String vehicleType, String make, String model, int productionYear, Double engineCapacity, String fuelType, Double fuelConsumption, Double rentPrice, boolean isAvailable/*, List<Accessory> accessories*/, int miniBusSeats, double cargoVolume, String miniBusColor) {
        MiniBus miniBus = new MiniBus();
        miniBus.setImage(image);
        miniBus.setVehicleType(vehicleType);
        miniBus.setMake(make);
        miniBus.setModel(model);
        miniBus.setProductionYear(productionYear);
        miniBus.setEngineCapacity(engineCapacity);
        miniBus.setFuelType(fuelType);
        miniBus.setFuelConsumption(fuelConsumption);
        miniBus.setRentPrice(rentPrice);
        miniBus.setIsAvailable(isAvailable);
        //miniBus.setAccessories(accessories);
        miniBus.setSeatNumber(miniBusSeats);
        miniBus.setCargoVolume(cargoVolume);
        miniBus.setMiniBusColor(miniBusColor);
        return miniBus;
    }
}
