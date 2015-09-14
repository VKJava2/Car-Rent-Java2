/*package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.MiniBusDAO;
import lv.javaguru.java2.domain.MiniBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MiniBusUpdateController implements MVCController {

    @Autowired
    private MiniBusDAO miniBusDAO;

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
} */
