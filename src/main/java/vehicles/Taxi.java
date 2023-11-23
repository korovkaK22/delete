package vehicles;

import humans.Human;

/**
 * Таксі, може возити усіх пасажирів
 */
public class Taxi extends Car<Human>{

    public Taxi(int seats, long transportID) {
        super(seats, transportID);
    }
}
