package service.permits.model;

import java.util.Objects;

public abstract class DefaultEntity implements BaseEntity {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseEntity)) {
            return false;
        }
        BaseEntity lookup = (BaseEntity) o;
        return Objects.equals(getId(), lookup.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
