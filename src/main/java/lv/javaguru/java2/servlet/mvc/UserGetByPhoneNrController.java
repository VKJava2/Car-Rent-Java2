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
public class UserGetByPhoneNrController implements MVCController {

    @Autowired
    private UserDAOImpl userDAO;

    public MVCModel processRequest(HttpServletRequest req) {

        String phoneNr = (String) req.getAttribute("PhoneNr");
        try {
            User user = userDAO.getByPhoneNr(phoneNr);

            if (user.getPhoneNr().equals(phoneNr)) {
                return new MVCModel(user, "/userByPhoneNr.jsp");
            } else {
                return new MVCModel(null, "/noUserFound.jsp");
            }
        } catch (DBException e) {
            return new MVCModel(null, "/errorpage.jsp");
        }
    }
}
