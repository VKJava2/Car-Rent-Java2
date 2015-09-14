package lv.javaguru.java2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "personalCar")
@PrimaryKeyJoinColumn(name="CarID")
public class PersonalCar extends Vehicle implements Serializable {

    @Column(name="LuxuryType")
    private String luxuryType;
    @Column(name="NumberOfDoors")
    private String numberOfDoors;
    @Column(name="BodyType")
    private String bodyType;


    public String getLuxuryType() {
        return luxuryType;
    }

    public void setLuxuryType(String usageType) {
        this.luxuryType = usageType;
    }

    public String getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(String numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

}