package lv.javaguru.java2.database.jdbc;


import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.PersonalCarDAO;
import lv.javaguru.java2.domain.PersonalCar;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonalCarDAOImpl extends DAOImpl implements PersonalCarDAO {


    public void create(PersonalCar personalCar) throws DBException {
        if (personalCar == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into VEHICLES (CarID, VehicleType, Make, Model, ProductionYear, EngineCapacity, " +
                            "FuelType, FuelConsumption, RentPrice, IsAvailable, LuxuryType, NumberOfDoors, BodyType) " +
                            "values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, personalCar.getVehicleType());
            preparedStatement.setString(2, personalCar.getMake());
            preparedStatement.setString(3, personalCar.getModel());
            preparedStatement.setInt(4, personalCar.getProductionYear());
            preparedStatement.setDouble(5, personalCar.getEngineCapacity());
            preparedStatement.setString(6, personalCar.getFuelType());
            preparedStatement.setDouble(7, personalCar.getFuelConsumption());
            preparedStatement.setDouble(8, personalCar.getRentPrice());
            preparedStatement.setBoolean(9, personalCar.isAvailable());
            preparedStatement.setString(10, personalCar.getLuxuryType());
            preparedStatement.setString(11, personalCar.getNumberOfDoors());
            preparedStatement.setString(12, personalCar.getBodyType());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                personalCar.setCarId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute PersonalCarDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public PersonalCar getById(String carID) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from VEHICLES where CarID = ?");
            preparedStatement.setString(1, carID);
            ResultSet resultSet = preparedStatement.executeQuery();
            PersonalCar personalCar = null;
            if (resultSet.next()) {
                personalCar = new PersonalCar();
                personalCar.setCarId(resultSet.getLong("CarID"));
                personalCar.setVehicleType(resultSet.getString("VehicleType"));
                personalCar.setMake(resultSet.getString("Make"));
                personalCar.setModel(resultSet.getString("Model"));
                personalCar.setProductionYear(resultSet.getInt("ProductionYear"));
                personalCar.setEngineCapacity(resultSet.getDouble("EngineCapacity"));
                personalCar.setFuelType(resultSet.getString("FuelType"));
                personalCar.setFuelConsumption(resultSet.getDouble("FuelConsumption"));
                personalCar.setRentPrice(resultSet.getDouble("RentPrice"));
                personalCar.setIsAvailable(resultSet.getBoolean("IsAvailable"));
                personalCar.setLuxuryType(resultSet.getString("LuxuryType"));
                personalCar.setNumberOfDoors(resultSet.getString("NumberOfDoors"));
                personalCar.setBodyType(resultSet.getString("BodyType"));
            }
            return personalCar;
        } catch (Throwable e) {
            System.out.println("Exception while execute PersonalCarDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<PersonalCar> getByMake(String manufacturer) throws DBException {
        Connection connection = null;

        List<PersonalCar> foundCars = new ArrayList<PersonalCar>();

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from VEHICLES where Make = ? and VehicleType = ?");
            preparedStatement.setString(1, manufacturer);
            preparedStatement.setString(2, "PersonalCar");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PersonalCar personalCar = new PersonalCar();
                personalCar.setCarId(resultSet.getLong("CarID"));
                personalCar.setVehicleType(resultSet.getString("VehicleType"));
                personalCar.setMake(resultSet.getString("Make"));
                personalCar.setModel(resultSet.getString("Model"));
                personalCar.setProductionYear(resultSet.getInt("ProductionYear"));
                personalCar.setEngineCapacity(resultSet.getDouble("EngineCapacity"));
                personalCar.setFuelType(resultSet.getString("FuelType"));
                personalCar.setFuelConsumption(resultSet.getDouble("FuelConsumption"));
                personalCar.setRentPrice(resultSet.getDouble("RentPrice"));
                personalCar.setIsAvailable(resultSet.getBoolean("IsAvailable"));
                personalCar.setLuxuryType(resultSet.getString("LuxuryType"));
                personalCar.setNumberOfDoors(resultSet.getString("NumberOfDoors"));
                personalCar.setBodyType(resultSet.getString("BodyType"));
                foundCars.add(personalCar);
            }
            return foundCars;
        } catch (Throwable e) {
            System.out.println("Exception while execute PersonalCarDAOImpl.getByMake()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<PersonalCar> getByLuxuryType(String luxuryType) throws DBException {
        Connection connection = null;

        List<PersonalCar> foundCars = new ArrayList<PersonalCar>();

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from VEHICLES where LuxuryType = ?");
            preparedStatement.setString(1, luxuryType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PersonalCar personalCar = new PersonalCar();
                personalCar.setCarId(resultSet.getLong("CarID"));
                personalCar.setVehicleType(resultSet.getString("VehicleType"));
                personalCar.setMake(resultSet.getString("Make"));
                personalCar.setModel(resultSet.getString("Model"));
                personalCar.setProductionYear(resultSet.getInt("ProductionYear"));
                personalCar.setEngineCapacity(resultSet.getDouble("EngineCapacity"));
                personalCar.setFuelType(resultSet.getString("FuelType"));
                personalCar.setFuelConsumption(resultSet.getDouble("FuelConsumption"));
                personalCar.setRentPrice(resultSet.getDouble("RentPrice"));
                personalCar.setIsAvailable(resultSet.getBoolean("IsAvailable"));
                personalCar.setLuxuryType(resultSet.getString("LuxuryType"));
                personalCar.setNumberOfDoors(resultSet.getString("NumberOfDoors"));
                personalCar.setBodyType(resultSet.getString("BodyType"));
                foundCars.add(personalCar);
            }
            return foundCars;
        } catch (Throwable e) {
            System.out.println("Exception while execute PersonalCarDAOImpl.getByLuxuryType()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<PersonalCar> getByBodyType(String bodyType) throws DBException {
        Connection connection = null;

        List<PersonalCar> foundCars = new ArrayList<PersonalCar>();

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from VEHICLES where BodyType = ?");
            preparedStatement.setString(1, bodyType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PersonalCar personalCar = new PersonalCar();
                personalCar.setCarId(resultSet.getLong("CarID"));
                personalCar.setVehicleType(resultSet.getString("VehicleType"));
                personalCar.setMake(resultSet.getString("Make"));
                personalCar.setModel(resultSet.getString("Model"));
                personalCar.setProductionYear(resultSet.getInt("ProductionYear"));
                personalCar.setEngineCapacity(resultSet.getDouble("EngineCapacity"));
                personalCar.setFuelType(resultSet.getString("FuelType"));
                personalCar.setFuelConsumption(resultSet.getDouble("FuelConsumption"));
                personalCar.setRentPrice(resultSet.getDouble("RentPrice"));
                personalCar.setIsAvailable(resultSet.getBoolean("IsAvailable"));
                personalCar.setLuxuryType(resultSet.getString("LuxuryType"));
                personalCar.setNumberOfDoors(resultSet.getString("NumberOfDoors"));
                personalCar.setBodyType(resultSet.getString("BodyType"));
                foundCars.add(personalCar);
            }
            return foundCars;
        } catch (Throwable e) {
            System.out.println("Exception while execute PersonalCarDAOImpl.getByBodyType()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<PersonalCar> getByFuelType(String fuelType ) throws DBException {
        Connection connection = null;

        List<PersonalCar> foundCars = new ArrayList<PersonalCar>();

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from VEHICLES where FuelType = ?  and VehicleType = ?");
            preparedStatement.setString(1, fuelType);
            preparedStatement.setString(2, "PersonalCar");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PersonalCar personalCar = new PersonalCar();
                personalCar.setCarId(resultSet.getLong("CarID"));
                personalCar.setVehicleType(resultSet.getString("VehicleType"));
                personalCar.setMake(resultSet.getString("Make"));
                personalCar.setModel(resultSet.getString("Model"));
                personalCar.setProductionYear(resultSet.getInt("ProductionYear"));
                personalCar.setEngineCapacity(resultSet.getDouble("EngineCapacity"));
                personalCar.setFuelType(resultSet.getString("FuelType"));
                personalCar.setFuelConsumption(resultSet.getDouble("FuelConsumption"));
                personalCar.setRentPrice(resultSet.getDouble("RentPrice"));
                personalCar.setIsAvailable(resultSet.getBoolean("IsAvailable"));
                personalCar.setLuxuryType(resultSet.getString("LuxuryType"));
                personalCar.setNumberOfDoors(resultSet.getString("NumberOfDoors"));
                personalCar.setBodyType(resultSet.getString("BodyType"));
                foundCars.add(personalCar);
            }
            return foundCars;
        } catch (Throwable e) {
            System.out.println("Exception while execute PersonalCarDAOImpl.getByFuelType()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<PersonalCar> getAll() throws DBException {
        Connection connection = null;

        List<PersonalCar> foundCars = new ArrayList<PersonalCar>();

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from VEHICLES where VehicleType = ?");
            preparedStatement.setString(1, "PersonalCar");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PersonalCar personalCar = new PersonalCar();
                personalCar.setCarId(resultSet.getLong("CarID"));
                personalCar.setVehicleType(resultSet.getString("VehicleType"));
                personalCar.setMake(resultSet.getString("Make"));
                personalCar.setModel(resultSet.getString("Model"));
                personalCar.setProductionYear(resultSet.getInt("ProductionYear"));
                personalCar.setEngineCapacity(resultSet.getDouble("EngineCapacity"));
                personalCar.setFuelType(resultSet.getString("FuelType"));
                personalCar.setFuelConsumption(resultSet.getDouble("FuelConsumption"));
                personalCar.setRentPrice(resultSet.getDouble("RentPrice"));
                personalCar.setIsAvailable(resultSet.getBoolean("IsAvailable"));
                personalCar.setLuxuryType(resultSet.getString("LuxuryType"));
                personalCar.setNumberOfDoors(resultSet.getString("NumberOfDoors"));
                personalCar.setBodyType(resultSet.getString("BodyType"));
                foundCars.add(personalCar);
            }
            return foundCars;
        } catch (Throwable e) {
            System.out.println("Exception while execute PersonalCarDAOImpl.getByMake()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(PersonalCar personalCar, Long id) throws DBException {
        if (personalCar == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update VEHICLES set VehicleType = ?, Make = ?, Model = ?, ProductionYear = ?, EngineCapacity = ?, FuelType = ?, FuelConsumption = ?, RentPrice = ?, IsAvailable = ?, LuxuryType = ?, NumberOfDoors = ?, BodyType = ? " +
                            "where CarID = id", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, personalCar.getVehicleType());
            preparedStatement.setString(2, personalCar.getMake());
            preparedStatement.setString(3, personalCar.getModel());
            preparedStatement.setInt(4, personalCar.getProductionYear());
            preparedStatement.setDouble(5, personalCar.getEngineCapacity());
            preparedStatement.setString(6, personalCar.getFuelType());
            preparedStatement.setDouble(7, personalCar.getFuelConsumption());
            preparedStatement.setDouble(8, personalCar.getRentPrice());
            preparedStatement.setBoolean(9, personalCar.isAvailable());
            preparedStatement.setString(10, personalCar.getLuxuryType());
            preparedStatement.setString(11, personalCar.getNumberOfDoors());
            preparedStatement.setString(12, personalCar.getBodyType());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute PersonalCarDAOImpl.update()");
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
                    .prepareStatement("delete from VEHICLES where CarID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute PersonalCarDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
}
