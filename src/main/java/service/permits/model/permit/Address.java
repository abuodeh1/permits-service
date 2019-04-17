package service.permits.model.permit;

import service.permits.lookup.Lookup;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class Address implements Serializable {

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="region")
    private Lookup region;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="province")
    private Lookup province;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="municipality")
    private Lookup municipality;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="district")
    private Lookup district;
    private String neighborhood;
    private String street;

    public Lookup getRegion() {
        return region;
    }

    public void setRegion(Lookup region) {
        this.region = region;
    }

    public Lookup getProvince() {
        return province;
    }

    public void setProvince(Lookup province) {
        this.province = province;
    }

    public Lookup getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Lookup municipality) {
        this.municipality = municipality;
    }

    public Lookup getDistrict() {
        return district;
    }

    public void setDistrict(Lookup district) {
        this.district = district;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}