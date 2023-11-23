import exceptions.FullVehicleException;
import humans.FireFighter;
import humans.Passenger;
import humans.PoliceOfficer;
import vehicles.Bus;
import vehicles.FireTruck;
import vehicles.PoliceCar;


public class Main {

    public static void main(String[] args) throws FullVehicleException {

        FireFighter fireFighter1 = new FireFighter("Sam", "Surname", "leader");
        FireFighter fireFighter2 = new FireFighter("Som", "SerName", "driver");
        PoliceOfficer cop1 = new PoliceOfficer("Stew", "Surname", 1);
        PoliceOfficer cop2 = new PoliceOfficer("Simsonu", "Bukasov", 3);
        PoliceOfficer cop3 = new PoliceOfficer("Rokky", "Free", 2);

        PoliceCar policeCar = new PoliceCar(2, 1);
        //policeCar.addPassenger(fireFighter1); // не можна пожежника в поліцейську машину пихати
        policeCar.addPassenger(cop1);
        policeCar.addPassenger(cop2);
        //policeCar.addPassenger(cop3); // в машині місця немає

        FireTruck fireTruck = new FireTruck(5, 2);
        fireTruck.addPassenger(fireFighter1);
        //fireTruck.addPassenger(fireFighter1);  // того самого пасажира додати не можна
        fireTruck.addPassenger(fireFighter2);
        fireTruck.removePassenger(fireFighter2);
        //fireTruck.removePassenger(fireFighter2); // того самого пасажира не можна випихнути

        Passenger passenger = new Passenger("Viktor", "Pavlovich");
        Bus bus = new Bus(4, 1);
        bus.addPassenger(fireFighter1);
        bus.addPassenger(cop1);
        bus.addPassenger(passenger);

        Road road = new Road();
        road.addCarToRoad(fireTruck);
        road.addCarToRoad(policeCar);
        road.addCarToRoad(bus);
        System.out.printf("All passengers: %d", road.getCountOfHumans());

    }
}
