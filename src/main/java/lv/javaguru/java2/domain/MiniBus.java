package lv.javaguru.java2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by XidenT on 28/07/2015.
 */

@Entity
@Table(name = "miniBus")
@PrimaryKeyJoinColumn(name="CarID")
public class MiniBus extends Vehicle implements Serializable {

    @Column(name="MiniBusSeats")
    private int seatNumber;
    @Column(name="CargoVolume")
    private double cargoVolume;
    @Column(name="MiniBusColor")
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
