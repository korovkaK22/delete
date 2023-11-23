import humans.Human;
import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;


/**
 * Дорога, зберігає в собі машини, які по ній їдуть
 */
public class Road {
    /**
     * Машини, які їдуть дорогою
     */
    private final List<Vehicle<? extends Human>> carsInRoad = new ArrayList<>();

    public Road(List<? extends Vehicle<? extends Human>> carsInRoad) {
        this.carsInRoad.addAll(carsInRoad);
    }

    public Road() {
    }

    /**
     * Порахувати всіх пасажирів, які зараз знаходяться на трасі
     * @return кількість пасажирів
     */
    public int getCountOfHumans(){
        return carsInRoad.stream()
                .mapToInt(Vehicle::getOccupiedSeats)
                .sum();
    }

    /**
     * Додати до дороги засіб пасажирів
     *
     * @param vehicle транспортний засіб
     * @throws NullPointerException Коли пасажир null
     */
    public <T extends Vehicle<? extends Human>> void addCarToRoad(T vehicle){
        if (vehicle == null) {
            throw new NullPointerException("Passenger is null");
        }
            carsInRoad.add(vehicle);
    }
}

