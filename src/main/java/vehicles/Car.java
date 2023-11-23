package vehicles;

import humans.Human;
/**
 * Абстрактний клас машин
 */
public abstract class Car<T extends Human> extends Vehicle<T> {

    public Car(int seats, long transportID) {
        super(seats, transportID);
    }
}
