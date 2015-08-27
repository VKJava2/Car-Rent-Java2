package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.MotorcycleDAO;
import lv.javaguru.java2.domain.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class MotorcycleController implements MVCController {

    @Autowired
    private MotorcycleDAOImpl motorcycleDAO;

    public MVCModel processRequest(HttpServletRequest req) {

//        MotorcycleDAO motorcycleDAO = new MotorcycleDAOImpl();
        try {
            List<Motorcycle> motorcycles = motorcycleDAO.getAll();

            if (!motorcycles.isEmpty()) {
                // ok
                return new MVCModel(motorcycles, "/motorcyclesList.jsp");
            } else {
                // no
                return new MVCModel(null, "/noMotorcyclesAvailable.jsp");
            }
        } catch (DBException e) {
            return new MVCModel(null, "/noMotorcyclesAvailable.jsp");
        }

    }

}