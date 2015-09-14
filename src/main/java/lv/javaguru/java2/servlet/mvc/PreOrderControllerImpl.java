package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.AccessoryDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.MotorcycleDAO;
import lv.javaguru.java2.domain.Accessory;
import lv.javaguru.java2.domain.Motorcycle;
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
    private AccessoryDAO accessoryDAO;

    @Transactional
    public MVCModel processRequest(HttpServletRequest req) {

        try {

            Motorcycle motorcycle = motorcycleDAO.getById(req.getParameter("id"));
            String availableFor = "Motorcycle";
            List<Accessory> accessories = accessoryDAO.getAll(availableFor);

            Map<String, Object> preOrderData = new HashMap<String, Object>();
            preOrderData.put("motorcycle", motorcycle);
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