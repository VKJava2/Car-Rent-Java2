package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by XidenT on 09/09/2015.
 */

@Component
public class UserGetByUserNameController implements MVCController {

    @Autowired
    private UserDAOImpl userDAO;

    public MVCModel processRequest(HttpServletRequest req) {

        String userName = (String) req.getAttribute("UserName");
        try {
            User user = userDAO.getByUserName(userName);

            if (user.getUserName().equals(userName)) {
                return new MVCModel(user, "/userByUserName.jsp");
            } else {
                return new MVCModel(null, "/noUserFound.jsp");
            }
        } catch (DBException e) {
            return new MVCModel(null, "/errorpage.jsp");
        }
    }
}
