package lld.theory;

interface Bird{
    void walk();
}
interface FlyingBird extends Bird{
    void fly();
}
class Sparrow implements FlyingBird{
    @Override
    public void walk(){
        System.out.println("bird is walking: "+ this.getClass().getName());
    }
    @Override
    public void fly(){
        System.out.println("bird is flying: "+ this.getClass().getName());
    }
}
class Ostrich implements Bird{

    @Override
    public void walk(){
        System.out.println("Bird is walking:" +this.getClass().getName());
    }
}
public class LiskovExample {
    public static void main(String[] args) {
        FlyingBird sparow = new Sparrow();
        sparow.walk();
        sparow.fly();

        Bird ostrich = new Ostrich();
        ostrich.walk();
    }
}
