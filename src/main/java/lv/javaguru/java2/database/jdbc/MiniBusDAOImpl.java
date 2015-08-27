package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.MiniBusDAO;
import lv.javaguru.java2.domain.Accessory;
import lv.javaguru.java2.domain.MiniBus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XidenT on 02/08/2015.
 */
public class MiniBusDAOImpl extends DAOImpl implements MiniBusDAO {

    public void create(MiniBus miniBus) throws DBException {
        if (miniBus == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO VEHICLES VALUES (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, miniBus.getVehicleType());
            preparedStatement.setString(2, miniBus.getMake());
            preparedStatement.setString(3, miniBus.getModel());
            preparedStatement.setInt(4, miniBus.getProductionYear());
            preparedStatement.setDouble(5, miniBus.getEngineCapacity());
            preparedStatement.setString(6, miniBus.getFuelType());
            preparedStatement.setDouble(7, miniBus.getFuelConsumption());
            preparedStatement.setDouble(8, miniBus.getRentPrice());
            preparedStatement.setBoolean(9, miniBus.isAvailable());
//            preparedStatement.setObject(9, miniBus.getAccessories());
            preparedStatement.setObject(10, miniBus.getSeatNumber());
            preparedStatement.setObject(11, miniBus.getCargoVolume());
            preparedStatement.setObject(12, miniBus.getMiniBusColor());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                miniBus.setCarId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while executing MiniBusDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public MiniBus getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM VEHICLES WHERE CarID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            MiniBus miniBus = null;
            if (resultSet.next()) {
                miniBus = new MiniBus();
                miniBus.setCarId(resultSet.getLong("CarID"));
                miniBus.setVehicleType(resultSet.getString("VehicleType"));
                miniBus.setMake(resultSet.getString("Make"));
                miniBus.setModel(resultSet.getString("Model"));
                miniBus.setProductionYear(resultSet.getInt("ProductionYear"));
                miniBus.setEngineCapacity(resultSet.getDouble("EngineCapacity"));
                miniBus.setFuelType(resultSet.getString("FuelType"));
                miniBus.setFuelConsumption(resultSet.getDouble("FuelConsumption"));
                miniBus.setRentPrice(resultSet.getDouble("RentPrice"));
                miniBus.setIsAvailable(resultSet.getBoolean("IsAvailable"));
//                miniBus.setAccessories((List<Accessory>) resultSet.getObject("Accessories"));
                miniBus.setSeatNumber(resultSet.getInt("MiniBusSeats"));
                miniBus.setCargoVolume(resultSet.getDouble("CargoVolume"));
                miniBus.setMiniBusColor(resultSet.getString("MiniBusColor"));
            }
            return miniBus;
        } catch (Throwable e) {
            System.out.println("Exception while executing MiniBusDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM VEHICLES WHERE CarID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while executing MiniBusDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(MiniBus miniBus) throws DBException {
        if (miniBus == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE VEHICLES SET VehicleType = ?, Make = ?, Model = ?, ProductionYear = ?, EngineCapacity = ?, FuelType = ?, FuelConsumption = ?, RentPrice = ?, IsAvailable = ?, /*Accessories = ?,*/ MiniBusSeats = ?, CargoVolume = ?, MiniBusColor = ?" +
                            "WHERE CarID = ?");
            preparedStatement.setString(1, miniBus.getVehicleType());
            preparedStatement.setString(2, miniBus.getMake());
            preparedStatement.setString(3, miniBus.getModel());
            preparedStatement.setInt(4, miniBus.getProductionYear());
            preparedStatement.setDouble(5, miniBus.getEngineCapacity());
            preparedStatement.setString(6, miniBus.getFuelType());
            preparedStatement.setDouble(7, miniBus.getFuelConsumption());
            preparedStatement.setDouble(8, miniBus.getRentPrice());
            preparedStatement.setBoolean(9, miniBus.isAvailable());
//            preparedStatement.setObject(8, miniBus.getAccessories());
            preparedStatement.setInt(10, miniBus.getSeatNumber());
            preparedStatement.setDouble(11, miniBus.getCargoVolume());
            preparedStatement.setString(12, miniBus.getMiniBusColor());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while executing MiniBusDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<MiniBus> getAll() throws DBException {
        List<MiniBus> miniBuses = new ArrayList<MiniBus>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM VEHICLES");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MiniBus miniBus = new MiniBus();
                miniBus.setCarId(resultSet.getLong("CarID"));
                miniBus.setVehicleType(resultSet.getString("VehicleType"));
                miniBus.setMake(resultSet.getString("Make"));
                miniBus.setModel(resultSet.getString("Model"));
                miniBus.setProductionYear(resultSet.getInt("ProductionYear"));
                miniBus.setEngineCapacity(resultSet.getDouble("EngineCapacity"));
                miniBus.setFuelType(resultSet.getString("FuelType"));
                miniBus.setFuelConsumption(resultSet.getDouble("FuelConsumption"));
                miniBus.setRentPrice(resultSet.getDouble("RentPrice"));
                miniBus.setIsAvailable(resultSet.getBoolean("IsAvailable"));
//                miniBus.setAccessories((List<Accessory>) resultSet.getObject("Accessories"));
                miniBus.setSeatNumber(resultSet.getInt("MiniBusSeats"));
                miniBus.setCargoVolume(resultSet.getDouble("CargoVolume"));
                miniBus.setMiniBusColor(resultSet.getString("MiniBusColor"));
                miniBuses.add(miniBus);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting minibus list MiniBusDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return miniBuses;
    }
}
