package vehicles;

import humans.PoliceOfficer;

/**
 * Поліцейська машина, може возити тільки поліцейських
 */
public class PoliceCar extends Car<PoliceOfficer>{

    public PoliceCar(int seats, long transportID) {
        super(seats, transportID);
    }
}
