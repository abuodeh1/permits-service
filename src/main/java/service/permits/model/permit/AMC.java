package service.permits.model.permit;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AMC implements Serializable {

    private String amcName;
    private String amcPhone;
    private String amcOfficer;

    public String getAmcName() {
        return amcName;
    }

    public void setAmcName(String amcName) {
        this.amcName = amcName;
    }

    public String getAmcPhone() {
        return amcPhone;
    }

    public void setAmcPhone(String amcPhone) {
        this.amcPhone = amcPhone;
    }

    public String getAmcOfficer() {
        return amcOfficer;
    }

    public void setAmcOfficer(String amcOfficer) {
        this.amcOfficer = amcOfficer;
    }
}
