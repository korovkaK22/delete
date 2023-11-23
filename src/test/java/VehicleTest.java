import exceptions.FullVehicleException;
import humans.FireFighter;
import humans.Human;
import humans.PoliceOfficer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vehicles.Bus;
import vehicles.FireTruck;
import vehicles.PoliceCar;
import vehicles.Taxi;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    private PoliceCar policeCar;
    private FireTruck fireTruck;
    private Bus bus;
    private Taxi taxi;

    @BeforeEach
    void setUp() {
        policeCar = new PoliceCar(2, 1);
        fireTruck = new FireTruck(2, 2);
        bus = new Bus(4, 3);
        taxi = new Taxi(4, 4);
    }

    @Test
    void testAddPoliceOfficerToPoliceCar() {
        PoliceOfficer officer = new PoliceOfficer("John", "Doe", 123);
        assertDoesNotThrow(() -> policeCar.addPassenger(officer));
    }


    @Test
    void testAddFireFighterToFireTruck() {
        FireFighter fireFighter = new FireFighter("Sam", "Smith", "leader");
        assertDoesNotThrow(() -> fireTruck.addPassenger(fireFighter));
    }

    @Test
    void testAddHumanToBus() {
        Human human = new Human("Jane", "Doe") {}; // Assuming Human is an abstract class
        FireFighter fireFighter = new FireFighter("Sam", "Smith", "leader");
        PoliceOfficer officer = new PoliceOfficer("John", "Doe", 123);
        assertDoesNotThrow(() -> bus.addPassenger(human));
        assertDoesNotThrow(() -> bus.addPassenger(fireFighter));
        assertDoesNotThrow(() -> bus.addPassenger(officer));
    }

    @Test
    void testAddHumanToTaxi() {
        Human human = new Human("Jane", "Doe") {}; // Assuming Human is an abstract class
        FireFighter fireFighter = new FireFighter("Sam", "Smith", "leader");
        PoliceOfficer officer = new PoliceOfficer("John", "Doe", 123);
        assertDoesNotThrow(() -> taxi.addPassenger(human));
        assertDoesNotThrow(() -> taxi.addPassenger(fireFighter));
        assertDoesNotThrow(() -> taxi.addPassenger(officer));
    }

    @Test
    void testVehicleOverCapacity() {
        PoliceOfficer officer1 = new PoliceOfficer("John", "Doe", 123);
        PoliceOfficer officer2 = new PoliceOfficer("Jane", "Doe", 456);
        PoliceOfficer officer3 = new PoliceOfficer("Jim", "Beam", 789);
        PoliceOfficer officer4 = new PoliceOfficer("John", "Beam", 789);
        PoliceOfficer officer5 = new PoliceOfficer("Sam", "Beam", 789);

        //police
        assertDoesNotThrow(() -> policeCar.addPassenger(officer1));
        assertDoesNotThrow(() -> policeCar.addPassenger(officer2));
        assertThrows(FullVehicleException.class, () -> policeCar.addPassenger(officer3));

        //bus
        assertDoesNotThrow(() -> bus.addPassenger(officer1));
        assertDoesNotThrow(() -> bus.addPassenger(officer2));
        assertDoesNotThrow(() -> bus.addPassenger(officer3));
        assertDoesNotThrow(() -> bus.addPassenger(officer4));
        assertThrows(FullVehicleException.class, () -> bus.addPassenger(officer5));
    }

    @Test
    void testAddSameHumanToTaxi() {
        Human human = new Human("Jane", "Doe") {}; // Assuming Human is an abstract class
        assertDoesNotThrow(() -> taxi.addPassenger(human));
        assertThrows(IllegalArgumentException.class, () -> taxi.addPassenger(human));
    }


    @Test
    void testRemoveSameHumanToBus() {
        Human human = new Human("Jane", "Doe") {}; // Assuming Human is an abstract class
        assertDoesNotThrow(() -> bus.addPassenger(human));
        assertDoesNotThrow(() -> bus.removePassenger(human));
        assertThrows(IllegalArgumentException.class, () -> bus.removePassenger(human));
    }

}
