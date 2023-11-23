package humans;

import java.util.Objects;

public class FireFighter extends Human {
    String position;

    public FireFighter(String name, String surname, String position) {
        super(name, surname);
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Position is incorrect");
        }
        this.position = position;
    }


    @Override
    public String toString() {
        return "FireFighter{" +
                "position='" + position + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FireFighter that = (FireFighter) o;

        if (!Objects.equals(position, that.position)) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
