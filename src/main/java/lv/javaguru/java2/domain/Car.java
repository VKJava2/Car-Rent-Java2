package lv.javaguru.java2.domain;

import javax.persistence.*;

/**
 * Created by VK on 2015.07.22..
 */

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CarID")
    private long carId;
    @Column(name="Make")
    private String make;
    @Column(name="Model")
    private String model;
    @Column(name="ProductionYear")
    private int productionYear;
    @Column(name="EngineCapacity")
    private double engineCapacity;

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
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
}
