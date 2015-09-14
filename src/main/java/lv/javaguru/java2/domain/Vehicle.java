package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VK on 2015.07.26..
 */

@Entity
@Table(name = "vehicles")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CarID")
    private long carId;
    @Column(name="VehicleType")
    private String vehicleType;
    @Column(name="Image")
    private String image;
    @Column(name="Make")
    private String make;
    @Column(name="Model")
    private String model;
    @Column(name="ProductionYear")
    private int productionYear;
    @Column(name="EngineCapacity")
    private double engineCapacity;
    @Column(name="FuelType")
    private String fuelType;
    @Column(name="FuelConsumption")
    private double fuelConsumption;
    @Column(name="RentPrice")
    private double rentPrice;
    @Column(name="IsAvailable")
    private boolean isAvailable;
//    @OneToMany(mappedBy = "vehicle", fetch=FetchType.EAGER)
//    private List<Accessory> accessories;

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

/*    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }   */
}
