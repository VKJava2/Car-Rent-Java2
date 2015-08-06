package lv.javaguru.java2.domain;

/**
 * Created by VK on 2015.08.03..
 */
public class Motorcycle extends Vehicle {

    private String engineTypeByStrokes;
    private String driveType;
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
