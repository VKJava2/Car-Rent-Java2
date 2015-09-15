package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.domain.Order;
import lv.javaguru.java2.domain.OrderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.*;

@Component
public class OrderControllerImpl implements OrderController {

    @Autowired
    private OrderFactory orderFactory;

    @Transactional
    public MVCModel processRequest(HttpServletRequest req) {

        String vehicleId = "";
        String vehicleType = "";
        String rentUntill = "";
        List<String> accessories = new ArrayList<String>();

        Enumeration enu = req.getParameterNames();
        while(enu.hasMoreElements()) {
            String paramName = (String) enu.nextElement();

            if (paramName.equals("VehicleId"))
                vehicleId = req.getParameter(paramName);
            else if (paramName.equals("VehicleType"))
                vehicleType = req.getParameter(paramName);
            else if (paramName.equals("Untill"))
                rentUntill = req.getParameter(paramName);
            else
                accessories.add(req.getParameter(paramName));
        }

        if (rentUntill.equals(""))
            return new MVCModel(null, "/dateErrorPage.jsp");

        Order order = orderFactory.createOrder(vehicleId, vehicleType, rentUntill, accessories);

        if (order != null) {
            return new MVCModel(order, "/order.jsp");
        } else {
            return new MVCModel(null, "/errorpage.jsp");
        }
    }
}