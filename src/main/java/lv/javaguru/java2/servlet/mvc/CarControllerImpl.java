/*package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.CarDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.MotorcycleDAO;
import lv.javaguru.java2.domain.Car;
import lv.javaguru.java2.domain.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Component
class CarControllerImpl implements CarController {

    @Autowired
 //   @Qualifier("CarDAO_HIBERNATE")
    private MotorcycleDAO motorcycleDAO;

    @Transactional
    public MVCModel processRequest(HttpServletRequest req) {
        String make = req.getParameter("make");
//        String password = req.getParameter("password");

        // check with database
//        CarDAO carDAO = new CarDAOImpl();
        try {

            Motorcycle motorcycle = motorcycleDAO.getByMake(make);

            if (motorcycle.getMake().equals("Honda")) {
                // ok
                return new MVCModel(motorcycle, "/carFound.jsp");
            } else {
                // no
                return new MVCModel(null, "/carNotFound.jsp");
            }

 //           Motorcycle motorcycle = createMotorcycle("Motorcycle", "toyota_rav4_2014.jpg", "Honda", "CB600F Hornet", 2007, 0.6, "Бензин", 6, 60, true, "4-тактный", "Цепь", "Street");
 //           motorcycleDAO.create(motorcycle);

 //               return new MVCModel(motorcycle, "/carFound.jsp");

        } catch (DBException e) {
            return new MVCModel(null, "/carNotFound.jsp");
        }

    }

/*    private Motorcycle createMotorcycle(String vehicleType, String image, String make, String model, int productionYear, double engineCapacity, String fuelType, double fuelConsumption,
                                        double rentPrice, boolean isAvailable, String engineTypeByStrokes, String driveType, String motorcycleType) {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setVehicleType(vehicleType);
        motorcycle.setImage(image);
        motorcycle.setMake(make);
        motorcycle.setModel(model);
        motorcycle.setProductionYear(productionYear);
        motorcycle.setEngineCapacity(engineCapacity);
        motorcycle.setFuelType(fuelType);
        motorcycle.setFuelConsumption(fuelConsumption);
        motorcycle.setRentPrice(rentPrice);
        motorcycle.setIsAvailable(isAvailable);
        motorcycle.setEngineTypeByStrokes(engineTypeByStrokes);
        motorcycle.setDriveType(driveType);
        motorcycle.setMotorcycleType(motorcycleType);
        return motorcycle;
    }

} */