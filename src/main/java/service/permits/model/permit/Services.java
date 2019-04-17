package service.permits.model.permit;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Services implements Serializable {

    private boolean hasSunshades;
    private boolean hasFacilities;
    private boolean hasTelephones;
    private boolean hasSeats;

    public boolean isHasSunshades() {
        return hasSunshades;
    }

    public void setHasSunshades(boolean hasSunshades) {
        this.hasSunshades = hasSunshades;
    }

    public boolean isHasFacilities() {
        return hasFacilities;
    }

    public void setHasFacilities(boolean hasFacilities) {
        this.hasFacilities = hasFacilities;
    }

    public boolean isHasTelephones() {
        return hasTelephones;
    }

    public void setHasTelephones(boolean hasTelephones) {
        this.hasTelephones = hasTelephones;
    }

    public boolean isHasSeats() {
        return hasSeats;
    }

    public void setHasSeats(boolean hasSeats) {
        this.hasSeats = hasSeats;
    }
}
