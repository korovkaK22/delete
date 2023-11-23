package vehicles;

import exceptions.FullVehicleException;
import humans.Human;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Абстрактний клас транспортних засобів, з повною реалізацією методів
 */
public abstract class Vehicle<T extends Human> {
    /**
     * Унікальний ID транспорту
     */
    private final long transportID;
    /**
     * Кількість місць у транспортному засобі.
     */
    private final int seats;
    /**
     * Список пасажирів
     */
    private final List<T> passengers = new LinkedList<>();

    public Vehicle(int seats, long transportID) {
        if (seats < 0) {
            throw new IllegalArgumentException("Seats can't be less zero");
        }
        if (transportID <= 0) {
            throw new IllegalArgumentException("transport id can't be less zero");
        }
        this.seats = seats;
        this.transportID = transportID;
    }

    /**
     * Метод для отримання загальної кількості місць.
     *
     * @return загальну кількість місць.
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Метод для отримання зайнятих місць.
     *
     * @return зайняті місця.
     */
    public int getOccupiedSeats() {
        return passengers.size();
    }

    /**
     * Додати в транспортний засіб пасажирів
     *
     * @param passenger пасажир
     * @throws NullPointerException Коли пасажир null
     * @throws FullVehicleException Коли транспортний засіб заповнений
     */

    public void addPassenger(T passenger) throws FullVehicleException {
        if (passenger == null) {
            throw new NullPointerException("Passenger is null");
        }
        if (passengers.size() >= seats) {
            throw new FullVehicleException("Vehicle is full");
        }
        if (passengers.contains(passenger)) {
            throw new IllegalArgumentException("Passenger already sit's " + passenger);
        }
        passengers.add(passenger);
    }

    /**
     * Додати в транспортний засіб пасажирів
     *
     * @param passenger пасажир
     * @throws NullPointerException     Коли пасажир null
     * @throws IllegalArgumentException Коли пасажира немає в цьому транспортному засобі
     */
    public void removePassenger(T passenger) throws IllegalArgumentException {
        if (passenger == null) {
            throw new NullPointerException("Passenger is null");
        }
        if (!passengers.contains(passenger)) {
            throw new IllegalArgumentException("Passenger isn't seat on this vehicle");
        }
        passengers.remove(passenger);
    }

    /**
     * Додати в транспортний засіб пасажирів
     *
     * @param passenger пасажир
     * @return чи сидить пасажир у цьому транспорті
     */
    public boolean hasPassenger(T passenger) {
        return passengers.contains(passenger);
    }

    /**
     * отримати id транспорту
     *
     * @return id транспорту
     */
    public long getTransportID() {
        return transportID;
    }

    /**
     * отримати пасажирів
     *
     * @return unmodifiableList пасажирів
     */
    public List<T> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle<?> vehicle = (Vehicle<?>) o;

        if (transportID != vehicle.transportID) return false;
        if (seats != vehicle.seats) return false;
        return passengers != null ? passengers.equals(vehicle.passengers) : vehicle.passengers == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (transportID ^ (transportID >>> 32));
        result = 31 * result + seats;
        result = 31 * result + (passengers != null ? passengers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "transportID=" + transportID +
                ", seats=" + seats +
                ", passengers=" + passengers +
                '}';
    }
}
