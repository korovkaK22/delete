package vehicles;

import humans.Human;
/**
 * Автобус, може возити всіх */
public class Bus extends Vehicle<Human> {

    public Bus(int seats, long transportID) {
        super(seats, transportID);
    }
}
