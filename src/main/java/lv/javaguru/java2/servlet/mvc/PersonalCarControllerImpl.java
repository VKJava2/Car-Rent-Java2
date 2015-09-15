package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.PersonalCarDAOImpl;
import lv.javaguru.java2.domain.PersonalCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class PersonalCarControllerImpl implements PersonalCarController {

    @Autowired
    private PersonalCarDAOImpl personalCarDAO;

    @Transactional
    public MVCModel processRequest(HttpServletRequest req) {

            try {
                List<PersonalCar> personalCarList = personalCarDAO.getAll();

                if (!personalCarList.isEmpty()) {
                    // ok
                    return new MVCModel(personalCarList, "/personalcarlist.jsp");
                } else {
                    // no
                    return new MVCModel(null, "/emptylist.jsp");
                }
            } catch (DBException e) {
                return new MVCModel(null, "/errorpage.jsp");
            }

        }

//        String vehicleType = req.getParameter("vType");
//        if(!vehicleType.isEmpty() && vehicleType.equals("personalcars")) {
//            return new MVCModel(null, "/personalcarslist.jsp");
//        } else if (vehicleType.isEmpty()) {
//            return new MVCModel(null, "/emptylist.jsp");
//        } else {
//            return new MVCModel(null, "/errorpage.jsp");
//        }


// ===================================================================
////        PersonalCarDAO personalCarDAO = new PersonalCarDAOImpl();
//        try {
//            String vehicleType = req.getParameter("vType");
//            if(!vehicleType.isEmpty() && vehicleType.equals("personalcars")  ) {
//                try {
//                    List<PersonalCar> personalCars = personalCarDAO.getAll();
//                    if (!personalCars.isEmpty()) {
//                        return new MVCModel(personalCars, "/personalcarslist.jsp");
//                    } else {
//                        return new MVCModel(null, "/emptylist.jsp");
//                    }
//                } catch (DBException e) {
//                    return new MVCModel(null, "/errorpage.jsp");
//                }
//            } else {
//                return new MVCModel(null, "/index.jsp");
//            }
//        } catch (NullPointerException e) {
//            return new MVCModel(null, "/errorpage.jsp");
//        }


}