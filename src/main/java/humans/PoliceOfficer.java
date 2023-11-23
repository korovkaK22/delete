package humans;

import java.util.Objects;

public class PoliceOfficer extends Human{
    int officerID;


    public PoliceOfficer(String name, String surname, int officerID) {
        super(name, surname);
        if (officerID <=0 ){
            throw new IllegalArgumentException("Illegal officer id");
        }
        this.officerID = officerID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PoliceOfficer that = (PoliceOfficer) o;

        if (officerID != that.officerID) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        int result = officerID;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PoliceOfficer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", officerID=" + officerID +
                '}';
    }


}


