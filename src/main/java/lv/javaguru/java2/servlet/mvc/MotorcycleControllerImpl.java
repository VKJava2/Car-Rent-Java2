package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.MotorcycleDAOImpl;
import lv.javaguru.java2.domain.Motorcycle;
import lv.javaguru.java2.domain.OrderTableCleaner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class MotorcycleControllerImpl implements MotorcycleController {

    @Autowired
    private MotorcycleDAOImpl motorcycleDAO;

    @Autowired
    private OrderTableCleaner orderTableCleaner;

    @Transactional
    public MVCModel processRequest(HttpServletRequest req) {

        try {
            String className = this.getClass().getSimpleName();
            orderTableCleaner.cleanOrders(className);

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