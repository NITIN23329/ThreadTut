package lld.questions.elevator;

import java.util.List;

public abstract class ElevatorSelectionStrategy {
    List<ElevatorController> elevatorControllerList;

    public ElevatorSelectionStrategy(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }
    abstract public ElevatorController getOptimalElevator(Request request);
}
