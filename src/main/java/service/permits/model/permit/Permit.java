package service.permits.model.permit;

import service.permits.lookup.Lookup;
import service.permits.model.BaseEntity;

import javax.persistence.*;

//@Audited
//@EntityListeners(AuditingEntityListener.class)
@Entity(name="Permits")
@Table(uniqueConstraints=@UniqueConstraint(columnNames="NAME"))
public class Permit implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
//    @NaturalId
//    @Column(unique = true, nullable = false, updatable = false, length = 100)
//    private String code;
    private String name;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nature")
    private Lookup nature;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="type")
    private Lookup type;

    private boolean enabled;

    @Embedded
    private Address address;
    @Embedded
    private Services services;
    @Embedded
    private Specifications specifications;
    @Embedded
    private AMC amc;

    public Permit() {}

    @Override
    public int getId() {
        return id;
    }

    @Override
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

    @Override
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
