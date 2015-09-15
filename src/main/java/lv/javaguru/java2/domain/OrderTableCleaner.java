package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by VK on 2015.09.12..
 */

@Component
public class OrderTableCleaner {

    @Autowired
    private MiniBusDAO miniBusDAO;
    @Autowired
    private MotorcycleDAO motorcycleDAO;
    @Autowired
    private PersonalCarDAO personalCarDAO;
    @Autowired
    private OrderDAO orderDAO;

    public void cleanOrders(String className) {

        try {

            List<Order> orders = orderDAO.getAll();

            Date orderExpiration = null;
            Date todayDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String vehicleId = "";

            for (Order order : orders){
                try {
                    orderExpiration = dateFormat.parse(order.getRentUntill());
                    if(todayDate.after(orderExpiration)){
                        vehicleId = String.valueOf(order.getVehicleId());
                        updateVehicleAvailibilty(className, vehicleId);
                        orderDAO.delete(order);
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (DBException e) {
            System.out.println("Exception while getting Orders in OrderTableCleaner");
            e.printStackTrace();
        }
    }

    private void updateVehicleAvailibilty(String className, String vehicleId){
        try{
            Vehicle vehicle = null;
            if (className.equals("MiniBusListAllControllerImpl"))
                vehicle = miniBusDAO.getById(vehicleId);
            else if (className.equals("MotorcycleControllerImpl"))
                vehicle = motorcycleDAO.getById(vehicleId);
            else if (className.equals("PersonalCarControllerImpl"))
                vehicle = personalCarDAO.getById(vehicleId);

            vehicle.setIsAvailable(true);

        } catch (DBException e){
            System.out.println("Exception while getting Vehicle in updateVehicleAvailibilty");
            e.printStackTrace();
        }
    }
}
