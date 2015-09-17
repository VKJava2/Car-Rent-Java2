package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.AccessoryDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.MiniBusDAOImpl;
import lv.javaguru.java2.database.jdbc.MotorcycleDAOImpl;
import lv.javaguru.java2.database.jdbc.PersonalCarDAOImpl;
import lv.javaguru.java2.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kano on 2015.09.17..
 */

@Component
public class CarInfoControllerImpl implements CarInfoController  {

    @Autowired
    private MotorcycleDAOImpl motorcycleDAO;

    @Autowired
    private MiniBusDAOImpl miniBusDAO;

    @Autowired
    private PersonalCarDAOImpl personalCarDAO;

    @Autowired
    private AccessoryDAO accessoryDAO;

    @Transactional
    public MVCModel processRequest(HttpServletRequest req) {

        try {

            Vehicle vehicle = null;
            Map<String,String> vehicleSpecials = null;
            if (req.getParameter("t").equals("mb")) {
                vehicle = miniBusDAO.getById(req.getParameter("id"));
                vehicleSpecials = miniBusDAO.getSpecials(req.getParameter("id"));
            }
            else if (req.getParameter("t").equals("m")) {
                vehicle = motorcycleDAO.getById(req.getParameter("id"));
                vehicleSpecials = motorcycleDAO.getSpecials(req.getParameter("id"));
            }
            else if (req.getParameter("t").equals("p")) {
                vehicle = personalCarDAO.getById(req.getParameter("id"));
                vehicleSpecials = personalCarDAO.getSpecials(req.getParameter("id"));
            }

            String availableFor = vehicle.getVehicleType();
            List<Accessory> accessories = accessoryDAO.getAll(availableFor);

            Map<String, Object> vehicleData = new HashMap<String, Object>();
            //preOrderData.put("motorcycle", motorcycle);
            vehicleData.put("type", vehicle.getVehicleType());
            vehicleData.put("vehicle", vehicle);
            vehicleData.put("specials", vehicleSpecials);
            vehicleData.put("accessories", accessories);
            if (!req.getParameter("t").isEmpty() || !req.getParameter("id").isEmpty()) {
                // ok
                return new MVCModel(vehicleData, "/vehicleinfo.jsp");
            } else {
                // no
                return new MVCModel(null, "/errorpage.jsp");
            }
        } catch (DBException e) {
            return new MVCModel(null, "/errorpage.jsp");
        }

    }
}
