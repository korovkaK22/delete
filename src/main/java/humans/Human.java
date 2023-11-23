package humans;

import java.util.Objects;

public abstract class Human {
    String name, surname;

    public Human(String name, String surname) {
        validate(name, surname);
        this.name = name;
        this.surname = surname;
    }

    /**
     * Валідація вхідних даних
     * @throws NullPointerException невалідні вхідні дані
     */
    private void validate(String name, String surname) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Name is incorrect");
        }
        if (surname == null || surname.trim().isEmpty()) {
            throw new NullPointerException("Surname is incorrect");
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (!Objects.equals(name, human.name)) return false;
        return Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}

