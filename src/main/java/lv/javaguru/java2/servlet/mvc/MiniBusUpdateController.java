package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.MiniBusDAOImpl;
import lv.javaguru.java2.domain.MiniBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by XidenT on 12/08/2015.
 */

@Component
public class MiniBusUpdateController implements MVCController {

    @Autowired
    private MiniBusDAOImpl miniBusDAO;

    public MVCModel processRequest(HttpServletRequest req) {

//        MiniBusDAO miniBusDAO = new MiniBusDAOImpl();

        Long id = (Long) req.getAttribute("CarID");
        try {
            MiniBus miniBus = miniBusDAO.getById(id);

            if(miniBus.getCarId() == id) {
                miniBusDAO.update(miniBus);
                return new MVCModel(miniBus, "/vehicleUpdated");
            } else {
                return new MVCModel(null, "/noVehicleFound.jsp");
            }
        } catch (DBException e) {
            return new MVCModel(null, "/carNotFound.jsp");
        }
    }
}
