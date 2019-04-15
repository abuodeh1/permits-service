package service.permits.model.permit;

import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import service.permits.lookup.Lookup;
import service.permits.model.AMC;

import javax.persistence.*;

@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name="Permits")
public class Permit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @NaturalId
    @Column(unique = true, nullable = false, updatable = false, length = 100)
    private String code;

    private String name;
    private String nameAr;

    private Lookup nature;
    private Lookup type;

    private boolean enabled;

    private Address address;
    private Services services;
    private Specifications specifications;

    @OneToOne
    private AMC amc;

    public Permit() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public Lookup getNature() {
        return nature;
    }

    public void setNature(Lookup nature) {
        this.nature = nature;
    }

    public Lookup getType() {
        return type;
    }

    public void setType(Lookup type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Specifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Specifications specifications) {
        this.specifications = specifications;
    }

    class Address{

        private Lookup region;
        private Lookup province;
        private Lookup municipality;
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

    class Services{

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

    class Specifications{

        private double area;
        private int sunshades;
        private int seats;
        private int lanes;
        private String notes;

        public double getArea() {
            return area;
        }

        public void setArea(double area) {
            this.area = area;
        }

        public int getSunshades() {
            return sunshades;
        }

        public void setSunshades(int sunshades) {
            this.sunshades = sunshades;
        }

        public int getSeats() {
            return seats;
        }

        public void setSeats(int seats) {
            this.seats = seats;
        }

        public int getLanes() {
            return lanes;
        }

        public void setLanes(int lanes) {
            this.lanes = lanes;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }
    }
}
