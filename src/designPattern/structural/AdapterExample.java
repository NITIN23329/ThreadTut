package designPattern.structural;

import java.util.ArrayList;
import java.util.List;

// let way we had an existing interface called Moveable and Flyable
interface Moveable{
    void move();
}
interface Flyable{
    void fly();
}
class Car implements  Moveable{
    @Override
    public void move(){
        System.out.println("Car is moving");
    }
}
class Airplane implements Flyable{
    @Override
    public void fly(){
        System.out.println("Airplane is flying");
    }
}
// let say we want to create a list of all transports and you dont want to change Moveable interface.
// so we can create a adapoter class which converts flyable object to moveable object
class FlyableToMoveableAdapter implements Moveable{
    Flyable flyable;

    public FlyableToMoveableAdapter(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void move(){
        flyable.fly();
    }
}

public class AdapterExample {
    public static void main(String[] args) {
        List<Moveable> vehicles = new ArrayList<>();
        Moveable car = new Car();
        Flyable airplane = new Airplane();
        vehicles.add(car);
        vehicles.add(new FlyableToMoveableAdapter(airplane));

        for(Moveable vehicle : vehicles) {
            vehicle.move();
        }
    }
}
