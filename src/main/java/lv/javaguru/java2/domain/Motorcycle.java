package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by VK on 2015.08.03..
 */

@Entity
@Table(name = "motorcycles")
@PrimaryKeyJoinColumn(name="CarID")

public class Motorcycle extends Vehicle implements Serializable {

    @Column(name="EngineTypeByStrokes")
    private String engineTypeByStrokes;
    @Column(name="DriveType")
    private String driveType;
    @Column(name="MotorcycleType")
    private String motorcycleType;

    public String getEngineTypeByStrokes() {
        return engineTypeByStrokes;
    }

    public void setEngineTypeByStrokes(String engineTypeByStrokes) {
        this.engineTypeByStrokes = engineTypeByStrokes;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getMotorcycleType() {
        return motorcycleType;
    }

    public void setMotorcycleType(String motorcycleType) {
        this.motorcycleType = motorcycleType;
    }
}
