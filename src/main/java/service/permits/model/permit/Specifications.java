package service.permits.model.permit;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Specifications implements Serializable {

    private double area;
    private int numberOfSunshades;
    private int numberOfSeats;
    private int numberOfLanes;
    private String notes;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getNumberOfSunshades() {
        return numberOfSunshades;
    }

    public void setNumberOfSunshades(int numberOfSunshades) {
        this.numberOfSunshades = numberOfSunshades;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfLanes() {
        return numberOfLanes;
    }

    public void setNumberOfLanes(int numberOfLanes) {
        this.numberOfLanes = numberOfLanes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
