package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.CarDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Component
class CarControllerImpl implements CarController {

    @Autowired
    @Qualifier("CarDAO_HIBERNATE")
    private CarDAO carDAO;

    @Transactional
    public MVCModel processRequest(HttpServletRequest req) {
        String make = req.getParameter("make");
//        String password = req.getParameter("password");

        // check with database
//        CarDAO carDAO = new CarDAOImpl();
        try {
            Car car = carDAO.getByMake(make);

            if (car.getMake().equals("Ford")) {
                // ok
                return new MVCModel(car, "/carFound.jsp");
            } else {
                // no
                return new MVCModel(null, "/carNotFound.jsp");
            }
        } catch (DBException e) {
            return new MVCModel(null, "/carNotFound.jsp");
        }

    }

}