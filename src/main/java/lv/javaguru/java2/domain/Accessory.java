package lv.javaguru.java2.domain;

import javax.persistence.*;

/**
 * Created by VK on 2015.07.26..
 */

@Entity
@Table(name = "accessories")
public class Accessory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="AccessoryID")
    private long accessoryId;
    @Column(name="Accessory")
    private String accessory;
    @Column(name="RentPrice")
    private double rentPrice;
    @Column(name="AvailableFor")
    private String availableFor;
//    @ManyToOne
 //   @JoinColumn(name="AvailableFor", referencedColumnName = "VehicleType")
//    @JoinColumn(name="AvailableFor")
 //   private Vehicle vehicle;

    public long getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(long accessoryId) {
        this.accessoryId = accessoryId;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getAvailableFor() {
        return availableFor;
    }

    public void setAvailableFor(String availableFor) {
        this.availableFor = availableFor;
    }
}
