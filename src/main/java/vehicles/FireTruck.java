package vehicles;

import humans.FireFighter;

/**
 * Пожежна машина, може возити тільки пожежних
 */
public class FireTruck extends Car<FireFighter>{
    public FireTruck(int seats, long transportID) {
        super(seats, transportID);
    }
}
