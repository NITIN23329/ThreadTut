package designPattern.behavioural;

import java.util.ArrayList;
import java.util.List;

// command interface
interface Command {
    void execute();
}
// receiver class, that does the actual work upon receiveing request from sender
class Light{
    int brightness = 0;
    public void turnOn(){
        this.brightness = 100;
        System.out.println("Light on: "+brightness);
    }
    public void turnOff(){
        this.brightness = 0;
        System.out.println("Light off: "+brightness);
    }
    public void dim(int x){
        if(x <= brightness){
            brightness -= x;
            System.out.println("Light dimmed to : "+brightness);
        }
    }
}
// create concrete command by having all the parameters needed by receiver as member variable
class LightTurnOnCommand implements Command{
    Light light;

    public LightTurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
class LightTurnOffCommand implements Command{
    Light light;

    public LightTurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
class LightDimCommand implements Command{
    Light light;
    int dim;

    public LightDimCommand(int dim, Light light) {
        this.dim = dim;
        this.light = light;
    }
    @Override
    public void execute() {
        light.dim(dim);
    }
}
// sender class, it may have many commands to invoke.
class LightControl {
    List<Command> commands;
    public LightControl() {
        commands = new ArrayList<Command>();
    }
    public void addCommand(Command command){
        commands.add(command);
    }
    public void execute(){
        for(Command command : commands){
            command.execute();
        }
    }
}
public class CommandExample {
    public static void main(String[] args) {
        Light light = new Light();

        Command turnOnCommand= new LightTurnOnCommand(light);
        Command dimCommand= new LightDimCommand(10,light);
        Command turnOfCommand= new LightTurnOffCommand(light);

        LightControl lightControl = new LightControl();
        lightControl.addCommand(turnOnCommand);
        lightControl.addCommand(dimCommand);
        lightControl.addCommand(turnOfCommand);

        lightControl.execute();

    }
}
