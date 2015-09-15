package lv.javaguru.java2.domain;

import javax.persistence.*;

/**
 * Created by VK on 2015.07.26..
 */

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="OrderID")
    private long orderId;
    @Column(name="Make")
    private String make;
    @Column(name="Model")
    private String model;
    @Column(name="RentUntill")
    private String rentUntill;
    @Column(name="RentPrice")
    private double rentPrice;
    @Column(name="RentAmount")
    private double rentAmount;
    @Column(name="AccessoriesTotal")
    private double accessoriesTotal;
    @Column(name="GrandTotal")
    private double grandTotal;
    @Column(name="CarID")
    private long vehicleId;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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

    public String getRentUntill() {
        return rentUntill;
    }

    public void setRentUntill(String rentUntill) {
        this.rentUntill = rentUntill;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public double getAccessoriesTotal() {
        return accessoriesTotal;
    }

    public void setAccessoriesTotal(double accessoriesTotal) {
        this.accessoriesTotal = accessoriesTotal;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
