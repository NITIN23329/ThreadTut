package lld.questions.elevator;

import java.util.List;

public class IdleElevatorSelectionStrategy extends ElevatorSelectionStrategy{
    public IdleElevatorSelectionStrategy(List<ElevatorController> elevatorControllerList) {
        super(elevatorControllerList);
    }

    @Override
    public ElevatorController getOptimalElevator(Request request) {
        for(ElevatorController elevatorController : elevatorControllerList) {
            if(elevatorController.getElevatorCar().getDisplay().getDirection().equals(Direction.IDLE))
                return elevatorController;
        }
        return null;
    }
}
