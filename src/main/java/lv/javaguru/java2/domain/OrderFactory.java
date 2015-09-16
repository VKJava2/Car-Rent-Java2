package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by VK on 2015.09.12..
 */

@Component
public class OrderFactory {

    @Autowired
    private MiniBusDAO miniBusDAO;
    @Autowired
    private MotorcycleDAO motorcycleDAO;
    @Autowired
    private PersonalCarDAO personalCarDAO;
    @Autowired
    private AccessoryDAO accessoryDAO;
    @Autowired
    private OrderDAO orderDAO;

    public Order createOrder(String vehicleId, String vehicleType, String rentUntill, List<String> accessories) {

        Order order = null;
        try{

            Vehicle vehicle = null;
            if (vehicleType.equals("MiniBus"))
                vehicle = miniBusDAO.getById(vehicleId);
            else if (vehicleType.equals("Motorcycle"))
                vehicle = motorcycleDAO.getById(vehicleId);
            else if (vehicleType.equals("PersonalCar"))
                vehicle = personalCarDAO.getById(vehicleId);

            int periodOfRent = getVehicleRentPeriod(rentUntill);

            String make = vehicle.getMake();
            String model = vehicle.getModel();
            double rentPrice = vehicle.getRentPrice();
            double rentAmount = rentPrice*periodOfRent;
            double accessoriesTotal = calculateAccessoriesTotal(accessories, periodOfRent);
            double grandTotal = rentAmount + accessoriesTotal;

            String orderId = createOrder(make, model, rentUntill, rentPrice,
                    rentAmount, accessoriesTotal, grandTotal, vehicleId);

            order = orderDAO.getById(orderId);

            if (order != null) {
                vehicle.setIsAvailable(false);
            }

        } catch (DBException e) {
            System.out.println("Exception while getting Vehicle in OrderFactory");
            e.printStackTrace();
        }
        return order;
    }


    private int getVehicleRentPeriod(String rentUntill){
        long periodOfRent = 0;
        Date rentUntillDateFormat = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            rentUntillDateFormat = dateFormat.parse(rentUntill);
            Date todayDate = new Date();
            //Nado vstavitj proverku esli ukazana data bolee rannaja chem tekuschaja.
            periodOfRent = rentUntillDateFormat.getTime() - todayDate.getTime();
            periodOfRent = TimeUnit.DAYS.convert(periodOfRent, TimeUnit.MILLISECONDS);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (int) periodOfRent;
    }

    private double calculateAccessoriesTotal(List<String> accessories, int periodOfRent){
        double accessoriesTotal = 0;
        try{
            for (String accId : accessories){
                Accessory accessory = accessoryDAO.getById(accId);
                double accRentPrice = accessory.getRentPrice();
                accessoriesTotal = accessoriesTotal + (accRentPrice*periodOfRent);
            }
        } catch (DBException e) {
            System.out.println("Exception while getting Vehicle in OrderFactory");
            e.printStackTrace();
        }
        return accessoriesTotal;
    }

    @Transactional
    private String createOrder(String make, String model, String rentUntill, double rentPrice,
                               double rentAmount, double accessoriesTotal, double grandTotal, String vehicleId){

        String createdOrderId = "";
        try{
            Order order = new Order();
            order.setMake(make);
            order.setModel(model);
            order.setRentUntill(rentUntill);
            order.setRentPrice(rentPrice);
            order.setRentAmount(rentAmount);
            order.setAccessoriesTotal(accessoriesTotal);
            order.setGrandTotal(grandTotal);
            order.setVehicleId(Long.valueOf(vehicleId));
            createdOrderId = orderDAO.create(order);

        }catch (DBException e) {
            System.out.println("Exception while creating Order in OrderFactory");
            e.printStackTrace();
        }
        return createdOrderId;
    }
}
