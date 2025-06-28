package designPattern.structural;
// we have multiple sub systems
class Lights{
    void switchOn(){System.out.println("Switch On the lights");}
    void switchOff(){System.out.println("Switch Off the lights");}
}
class Thermostat{
    void setTemperature(int temperature){
        System.out.println("Thermostat set temperature to " + temperature);
    }
}
class Fan{
    void setSpeed(int speed){System.out.println("Fan set speed to " + speed);}
}
// on create a facade class to manage all of them which are reqired
class HomeFacade {
    Lights lights ;
    Fan fan;

    public HomeFacade(){
        lights = new Lights();
        fan = new Fan();
    }
    public void arriveHome(){
        lights.switchOn();
        fan.setSpeed(20);
        System.out.println("Welcome home!!");
    }

}
public class FacadeExample {

    public static void main(String[] args) {
        HomeFacade home = new HomeFacade();
        home.arriveHome();
    }
}
