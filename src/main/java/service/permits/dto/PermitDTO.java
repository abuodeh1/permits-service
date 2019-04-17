package service.permits.dto;

import service.permits.lookup.Lookup;
import service.permits.model.permit.AMC;
import service.permits.model.permit.Address;
import service.permits.model.permit.Services;
import service.permits.model.permit.Specifications;

public class PermitDTO implements BaseDTO{

    private int id;
//    private String code;
    private String name;

    private Lookup nature;
    private Lookup type;

    private boolean enabled;

    private Address address;
    private Services services;
    private Specifications specifications;

    private AMC amc;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public AMC getAmc() {
        return amc;
    }

    public void setAmc(AMC amc) {
        this.amc = amc;
    }
}
