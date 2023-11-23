package vehicles;

import humans.Human;

/**
 * Таксі, може возити усіх пасажирів
 */
public class Taxi <T extends Human> extends Car<T>{

    public Taxi(int seats, long transportID) {
        super(seats, transportID);
    }
}
