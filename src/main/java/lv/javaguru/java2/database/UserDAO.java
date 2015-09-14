package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.User;

import java.util.List;

/**
 * Created by XidenT on 06/09/2015.
 */
public interface UserDAO {

    void create(User user) throws DBException;

    User getById(Long id) throws DBException;

    User getByFirstName(String firstName) throws DBException;

    User getByLastName(String lastName) throws DBException;

    User getByInitials(String firstName, String lastName) throws DBException;

    User getByUserName(String userName) throws DBException;

    User getByPhoneNr(String phoneNr) throws DBException;

    User getByEmail(String email) throws DBException;

    void delete(Long id) throws DBException;

    void update(User user) throws DBException;

    List<User> getAll() throws DBException;
}
