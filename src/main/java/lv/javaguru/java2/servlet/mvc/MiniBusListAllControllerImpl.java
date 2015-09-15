package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.MiniBusDAOImpl;
import lv.javaguru.java2.domain.MiniBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class MiniBusListAllControllerImpl implements MiniBusController {

    @Autowired
    private MiniBusDAOImpl miniBusDAO;

    @Transactional
    public MVCModel processRequest(HttpServletRequest req) {

        try {
            List<MiniBus> miniBuses = miniBusDAO.getAll();

            if (!miniBuses.isEmpty()) {
                return new MVCModel(miniBuses, "/miniBusList.jsp");
            } else {
                return new MVCModel(null, "/noMiniBusAvailable.jsp");
            }
        } catch (DBException e) {
            return new MVCModel(null, "/errorpage.jsp");
        }
    }
}
