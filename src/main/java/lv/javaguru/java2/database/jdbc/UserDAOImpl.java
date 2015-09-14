package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XidenT on 07/09/2015.
 */

@Component
public class UserDAOImpl extends DAOImpl implements UserDAO {

    public void create(User user) throws DBException {
        if (user == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into USERS values (default, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getPhoneNr());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getBankAccNr());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                user.setUserId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while executing UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public User getById(Long id) throws DBException {
        Connection connection = null;

            try {
                connection = getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("select * from USERS where UserID = ?");
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                User user = null;
                if (resultSet.next()) {
                    user = new User();
                    user.setUserId(resultSet.getLong("UserID"));
                    user.setFirstName(resultSet.getString("FirstName"));
                    user.setLastName(resultSet.getString("LastName"));
                    user.setUserName(resultSet.getString("UserName"));
                    user.setPassword(resultSet.getString("Password"));
                    user.setPhoneNr(resultSet.getString("PhoneNr"));
                    user.setEmail(resultSet.getString("Email"));
                    user.setBankAccNr(resultSet.getString("BankAccount"));
                }
                return user;
            } catch (Throwable e) {
                System.out.println("Exception while executing UserDAOImpl.getById()");
                e.printStackTrace();
                throw new DBException(e);
            } finally {
                closeConnection(connection);
        }
    }

    public User getByFirstName(String firstName) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from USERS where FirstName = ?");
            preparedStatement.setString(1, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getLong("UserID"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPassword(resultSet.getString("Password"));
                user.setPhoneNr(resultSet.getString("PhoneNr"));
                user.setEmail(resultSet.getString("Email"));
                user.setBankAccNr(resultSet.getString("BankAccount"));
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while executing UserDAOImpl.getByFirstName()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public User getByLastName(String lastName) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from USERS where LastName = ?");
            preparedStatement.setString(1, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getLong("UserID"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPassword(resultSet.getString("Password"));
                user.setPhoneNr(resultSet.getString("PhoneNr"));
                user.setEmail(resultSet.getString("Email"));
                user.setBankAccNr(resultSet.getString("BankAccount"));
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while executing UserDAOImpl.getByLastName()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public User getByInitials(String firstName, String lastName) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from USERS where FirstName = ? and LastName = ?");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getLong("UserID"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPassword(resultSet.getString("Password"));
                user.setPhoneNr(resultSet.getString("PhoneNr"));
                user.setEmail(resultSet.getString("Email"));
                user.setBankAccNr(resultSet.getString("BankAccount"));
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while executing UserDAOImpl.getByInitials()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public User getByUserName(String userName) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from USERS where UserName = ?");
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getLong("UserID"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPassword(resultSet.getString("Password"));
                user.setPhoneNr(resultSet.getString("PhoneNr"));
                user.setEmail(resultSet.getString("Email"));
                user.setBankAccNr(resultSet.getString("BankAccount"));
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while executing UserDAOImpl.getByUserName()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public User getByPhoneNr(String phoneNr) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from USERS where PhoneNr = ?");
            preparedStatement.setString(1, phoneNr);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getLong("UserID"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPassword(resultSet.getString("Password"));
                user.setPhoneNr(resultSet.getString("PhoneNr"));
                user.setEmail(resultSet.getString("Email"));
                user.setBankAccNr(resultSet.getString("BankAccount"));
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while executing UserDAOImpl.getByPhoneNr()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public User getByEmail(String email) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from USERS where Email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getLong("UserID"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPassword(resultSet.getString("Password"));
                user.setPhoneNr(resultSet.getString("PhoneNr"));
                user.setEmail(resultSet.getString("Email"));
                user.setBankAccNr(resultSet.getString("BankAccount"));
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while executing UserDAOImpl.getByEmail()");
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
                    .prepareStatement("delete from USERS where UserID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while executing UserDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(User user) throws DBException {
        if (user == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update USERS set FirstName = ?, LastName = ?, UserName = ?, Password = ?," +
                            "PhoneNr = ?, Email = ?, BankAccount = ? where UserID = ?");
            preparedStatement.setLong(1, user.getUserId());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getUserName());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getPhoneNr());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setString(8, user.getBankAccNr());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while executing UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<User> getAll() throws DBException {
        List<User> users = new ArrayList<User>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from USERS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong("UserID"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPassword(resultSet.getString("Password"));
                user.setPhoneNr(resultSet.getString("PhoneNr"));
                user.setEmail(resultSet.getString("Email"));
                user.setBankAccNr(resultSet.getString("BankAccount"));
                users.add(user);
            }
        } catch (Throwable e) {
            System.out.println("Exception while executing UserDAOImpl.getAll()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return users;
    }

}
