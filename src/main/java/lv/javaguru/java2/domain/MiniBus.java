package lv.javaguru.java2.domain;

import java.util.List;

/**
 * Created by XidenT on 28/07/2015.
 */
public class MiniBus extends Vehicle {

    private int seatNumber;
    private double cargoVolume;
    private String miniBusColor;

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(double cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    public String getMiniBusColor() {
        return miniBusColor;
    }

    public void setMiniBusColor(String miniBusColor) {
        this.miniBusColor = miniBusColor;
    }
}
