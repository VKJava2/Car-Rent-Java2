package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.CarDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Car;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VK on 2015.07.22..
 */

@Component("CarDAO_JDBC")
public class CarDAOImpl extends DAOImpl implements CarDAO {

    public void create(Car car) throws DBException {
        if (car == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into CARS values (default, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, car.getMake());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getProductionYear());
            preparedStatement.setDouble(4, car.getEngineCapacity());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                car.setCarId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute CarDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public Car getByMake(String make) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from CARS where Make = ?");
            preparedStatement.setString(1, make);
            ResultSet resultSet = preparedStatement.executeQuery();
            Car car = null;
            if (resultSet.next()) {
                car = new Car();
                car.setCarId(resultSet.getLong("CarID"));
                car.setMake(resultSet.getString("Make"));
                car.setModel(resultSet.getString("Model"));
                car.setProductionYear(resultSet.getInt("ProductionYear"));
                car.setEngineCapacity(resultSet.getDouble("EngineCapacity"));
            }
            return car;
        } catch (Throwable e) {
            System.out.println("Exception while execute CarDAOImpl.getByMake()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Car> getAll() throws DBException {
        List<Car> cars = new ArrayList<Car>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from USERS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Car car = new Car();
                car.setCarId(resultSet.getLong("CarID"));
                car.setMake(resultSet.getString("Make"));
                car.setModel(resultSet.getString("Model"));
                car.setProductionYear(resultSet.getInt("ProductionYear"));
                car.setEngineCapacity(resultSet.getDouble("EngineCapacity"));
                cars.add(car);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting car list CarDAOImpl.getAll()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return cars;
    }

    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from CARS where CarID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute CarDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(Car car) throws DBException {
        if (car == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update CARS set Make = ?, Model = ?, ProductionYear = ?, EngineCapacity = ? " +
                            "where UserID = ?");
            preparedStatement.setString(1, car.getMake());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getProductionYear());
            preparedStatement.setDouble(4, car.getEngineCapacity());
            preparedStatement.setLong(5, car.getCarId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute CarDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}