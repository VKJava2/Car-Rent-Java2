package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.MotorcycleDAO;
import lv.javaguru.java2.domain.Motorcycle;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VK on 2015.07.22..
 */

@Component
public class MotorcycleDAOImpl extends DAOImpl implements MotorcycleDAO {

    public void create(Motorcycle motorcycle) throws DBException {
        if (motorcycle == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into VEHICLES (CarID, VehicleType, Make, Model, ProductionYear, EngineCapacity, " +
                            "FuelType, FuelConsumption, RentPrice, IsAvailable, EngineTypeByStrokes, DriveType, MotorcycleType) " +
                            "values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, motorcycle.getVehicleType());
            preparedStatement.setString(2, motorcycle.getMake());
            preparedStatement.setString(3, motorcycle.getModel());
            preparedStatement.setInt(4, motorcycle.getProductionYear());
            preparedStatement.setDouble(5, motorcycle.getEngineCapacity());
            preparedStatement.setString(6, motorcycle.getFuelType());
            preparedStatement.setDouble(7, motorcycle.getFuelConsumption());
            preparedStatement.setDouble(8, motorcycle.getRentPrice());
            preparedStatement.setBoolean(9, motorcycle.isAvailable());
            preparedStatement.setString(10, motorcycle.getEngineTypeByStrokes());
            preparedStatement.setString(11, motorcycle.getDriveType());
            preparedStatement.setString(12, motorcycle.getMotorcycleType());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                motorcycle.setCarId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute MotorcycleDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public Motorcycle getByMake(String make) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from VEHICLES where Make = ? and VehicleType = ?");
            preparedStatement.setString(1, make);
            preparedStatement.setString(2, "Motorcycle");
            ResultSet resultSet = preparedStatement.executeQuery();
            Motorcycle motorcycle = null;
            if (resultSet.next()) {
                motorcycle = new Motorcycle();
                motorcycle.setCarId(resultSet.getLong("CarID"));
                motorcycle.setVehicleType(resultSet.getString("VehicleType"));
                motorcycle.setMake(resultSet.getString("Make"));
                motorcycle.setModel(resultSet.getString("Model"));
                motorcycle.setProductionYear(resultSet.getInt("ProductionYear"));
                motorcycle.setEngineCapacity(resultSet.getDouble("EngineCapacity"));
                motorcycle.setFuelType(resultSet.getString("FuelType"));
                motorcycle.setFuelConsumption(resultSet.getDouble("FuelConsumption"));
                motorcycle.setRentPrice(resultSet.getDouble("RentPrice"));
                motorcycle.setIsAvailable(resultSet.getBoolean("IsAvailable"));
                motorcycle.setEngineTypeByStrokes(resultSet.getString("EngineTypeByStrokes"));
                motorcycle.setDriveType(resultSet.getString("DriveType"));
                motorcycle.setMotorcycleType(resultSet.getString("MotorcycleType"));
            }
            return motorcycle;
        } catch (Throwable e) {
            System.out.println("Exception while execute MotorcycleDAOImpl.getByMake()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Motorcycle getById(String id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from VEHICLES where CarID = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Motorcycle motorcycle = null;
            if (resultSet.next()) {
                motorcycle = new Motorcycle();
                motorcycle.setCarId(resultSet.getLong("CarID"));
                motorcycle.setVehicleType(resultSet.getString("VehicleType"));
                motorcycle.setMake(resultSet.getString("Make"));
                motorcycle.setModel(resultSet.getString("Model"));
                motorcycle.setProductionYear(resultSet.getInt("ProductionYear"));
                motorcycle.setEngineCapacity(resultSet.getDouble("EngineCapacity"));
                motorcycle.setFuelType(resultSet.getString("FuelType"));
                motorcycle.setFuelConsumption(resultSet.getDouble("FuelConsumption"));
                motorcycle.setRentPrice(resultSet.getDouble("RentPrice"));
                motorcycle.setIsAvailable(resultSet.getBoolean("IsAvailable"));
                motorcycle.setEngineTypeByStrokes(resultSet.getString("EngineTypeByStrokes"));
                motorcycle.setDriveType(resultSet.getString("DriveType"));
                motorcycle.setMotorcycleType(resultSet.getString("MotorcycleType"));
            }
            return motorcycle;
        } catch (Throwable e) {
            System.out.println("Exception while execute MotorcycleDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Motorcycle> getAll() throws DBException {
        List<Motorcycle> motorcycles = new ArrayList<Motorcycle>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from VEHICLES where VehicleType = ?");
            preparedStatement.setString(1, "Motorcycle");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Motorcycle motorcycle = new Motorcycle();
                motorcycle.setCarId(resultSet.getLong("CarID"));
                motorcycle.setVehicleType(resultSet.getString("VehicleType"));
                motorcycle.setMake(resultSet.getString("Make"));
                motorcycle.setModel(resultSet.getString("Model"));
                motorcycle.setProductionYear(resultSet.getInt("ProductionYear"));
                motorcycle.setEngineCapacity(resultSet.getDouble("EngineCapacity"));
                motorcycle.setFuelType(resultSet.getString("FuelType"));
                motorcycle.setFuelConsumption(resultSet.getDouble("FuelConsumption"));
                motorcycle.setRentPrice(resultSet.getDouble("RentPrice"));
                motorcycle.setIsAvailable(resultSet.getBoolean("IsAvailable"));
                motorcycle.setEngineTypeByStrokes(resultSet.getString("EngineTypeByStrokes"));
                motorcycle.setDriveType(resultSet.getString("DriveType"));
                motorcycle.setMotorcycleType(resultSet.getString("MotorcycleType"));
                motorcycles.add(motorcycle);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting car list MotorcycleDAOImpl.getAll()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return motorcycles;
    }
}