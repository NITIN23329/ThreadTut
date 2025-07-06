package lld.questions.elevator;

public class ElevatorController {
    private ElevatorCar elevatorCar;
    private ElevatorControlStrategy elevatorControlStrategy;


    public ElevatorController(ElevatorCar elevatorCar, ElevatorControlStrategy elevatorControlStrategy) {
        this.elevatorCar = elevatorCar;
        this.elevatorControlStrategy = elevatorControlStrategy;
    }

    public void acceptRequest(Request request) {
        elevatorControlStrategy.acceptRequest(request);
        controlCar();

    }
    private void controlCar(){
        elevatorControlStrategy.moveElevator(this);
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public ElevatorControlStrategy getElevatorControlStrategy() {
        return elevatorControlStrategy;
    }
}
