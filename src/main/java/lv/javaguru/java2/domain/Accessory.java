package lv.javaguru.java2.domain;

/**
 * Created by VK on 2015.07.26..
 */
public class Accessory {

    private long accessoryId;
    private String accessory;
    private int rentPrice;

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

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }
}
