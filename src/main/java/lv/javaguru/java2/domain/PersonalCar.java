package lv.javaguru.java2.domain;


public class PersonalCar extends Vehicle {

    private String luxuryType;
    private String numberOfDoors;
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