package lv.javaguru.java2.domain;

/**
 * Created by VK on 2015.07.26..
 */
public class Accessory {

    private long accessoryId;
    private String accessory;
    private double rentPrice;
    private boolean isAvailableForMotorcycles;
    private boolean isAvailableForPersonalVehicles;
    private boolean isAvailableForPassengerVehicles;

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

    public boolean isAvailableForMotorcycles() {
        return isAvailableForMotorcycles;
    }

    public void setIsAvailableForMotorcycles(boolean isAvailableForMotorcycles) {
        this.isAvailableForMotorcycles = isAvailableForMotorcycles;
    }

    public boolean isAvailableForPersonalVehicles() {
        return isAvailableForPersonalVehicles;
    }

    public void setIsAvailableForPersonalVehicles(boolean isAvailableForPersonalVehicles) {
        this.isAvailableForPersonalVehicles = isAvailableForPersonalVehicles;
    }

    public boolean isAvailableForPassengerVehicles() {
        return isAvailableForPassengerVehicles;
    }

    public void setIsAvailableForPassengerVehicles(boolean isAvailableForPassengerVehicles) {
        this.isAvailableForPassengerVehicles = isAvailableForPassengerVehicles;
    }
}
