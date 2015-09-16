package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.*;
import lv.javaguru.java2.domain.Accessory;
import lv.javaguru.java2.domain.MiniBus;
import lv.javaguru.java2.domain.Motorcycle;
import lv.javaguru.java2.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PreOrderControllerImpl implements PreOrderController {

    @Autowired
    private MotorcycleDAO motorcycleDAO;

    @Autowired
    private MiniBusDAO miniBusDAO;

    @Autowired
    private PersonalCarDAO personalCarDAO;

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
            //Motorcycle motorcycle = motorcycleDAO.getById(req.getParameter("id"));
            String availableFor = vehicle.getVehicleType();
            List<Accessory> accessories = accessoryDAO.getAll(availableFor);

            Map<String, Object> preOrderData = new HashMap<String, Object>();
            //preOrderData.put("motorcycle", motorcycle);
            preOrderData.put("type", vehicle.getVehicleType());
            preOrderData.put("vehicle", vehicle);
            preOrderData.put("specials", vehicleSpecials);
            preOrderData.put("accessories", accessories);

            if (!preOrderData.isEmpty()) {
                return new MVCModel(preOrderData, "/preOrder.jsp");
            } else {
                return new MVCModel(null, "/noVehicleFound.jsp");
            }
        } catch (DBException e) {
            return new MVCModel(null, "/noVehicleFound.jsp");
        }

    }

}