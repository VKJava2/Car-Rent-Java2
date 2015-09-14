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
public class UserGetByIdController implements MVCController {

    @Autowired
    private UserDAOImpl userDAO;

    public MVCModel processRequest(HttpServletRequest req) {

        Long id = (Long) req.getAttribute("UserID");
        try {
            User user = userDAO.getById(id);

            if (user.getUserId() == id) {
                return new MVCModel(user, "/userById.jsp");
            } else {
                return new MVCModel(null, "/noUserFound.jsp");
            }
        } catch (DBException e) {
            return new MVCModel(null, "/errorpage.jsp");
        }
    }
}
