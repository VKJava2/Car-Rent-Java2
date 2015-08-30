package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.MiniBusDAOImpl;
import lv.javaguru.java2.domain.MiniBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by XidenT on 10/08/2015.
 */

@Component
public class MiniBusListAllController implements MVCController {

    @Autowired
    private MiniBusDAOImpl miniBusDAO;

    public MVCModel processRequest(HttpServletRequest req) {

//        MiniBusDAO miniBusDAO = new MiniBusDAOImpl();

        try {
            List<MiniBus> miniBuses = miniBusDAO.getAll();

            if (!miniBuses.isEmpty()) {
                return new MVCModel(miniBuses, "/miniBusList.jsp");
            } else {
                return new MVCModel(null, "/noMiniBusAvailable.jsp");
            }
        } catch (DBException e) {
            return new MVCModel(null, "/carNotFound.jsp");
        }
    }
}
