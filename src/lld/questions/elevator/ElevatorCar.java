package lld.questions.elevator;

import java.util.ArrayList;
import java.util.List;

// this is a dumb elevator, we will use elevator controller to control a partuclar elvator movement
public class ElevatorCar {
    private int id;
    List<InternalButton> buttons;
    Display display;

    public ElevatorCar(int id) {
        this.id = id;
        buttons = new ArrayList<>();
        display = new Display();
        // add buttons for all floors
        for(int i=1;i<=5;i++){
            buttons.add(new InternalButton("Floor "+i));
        }
    }

    public void move(Request request) {
        System.out.println("Moving to new floor : "+ request.getFloor() +" from current floor: "+display.getCurrentFloor());
        display.setCurrentFloor(request.getFloor());
        display.setDirection(request.getDirection());
    }

    public void pressButton(int toFloor){
        int currFloor = display.getCurrentFloor();
        Direction direction = Direction.IDLE;
        if(toFloor > currFloor) direction=Direction.UP;
        else direction=Direction.DOWN;

        for(InternalButton button : buttons){
            if(button.getButtonName().endsWith(""+toFloor)){
                button.pressButton(toFloor,direction, id);
                break;
            }
        }

    }

    public int getId() {
        return id;
    }

    public Display getDisplay() {
        return display;
    }


}
