package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by XidenT on 08/09/2015.
 */

@Component
public class UserGetByLastNameController implements MVCController {

    @Autowired
    private UserDAOImpl userDAO;

    public MVCModel processRequest(HttpServletRequest req) {

        String lastName = (String) req.getAttribute("LastName");
        try {
            User user = userDAO.getByLastName(lastName);

            if (user.getLastName().equals(lastName)) {
                return new MVCModel(user, "/userByLastName.jsp");
            } else {
                return new MVCModel(null, "/noUserFound.jsp");
            }
        } catch (DBException e) {
            return new MVCModel(null, "/errorpage.jsp");
        }
    }
}
