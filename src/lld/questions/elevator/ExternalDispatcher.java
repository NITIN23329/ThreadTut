package lld.questions.elevator;

// this dispatcher is used to find the optmial elevator which will be assigned to user
public class ExternalDispatcher extends Dispatcher {
    private ElevatorSelectionStrategy elevatorSelectionStrategy;

    public ExternalDispatcher(ElevatorSelectionStrategy elevatorSelectionStrategy) {
        this.elevatorSelectionStrategy = elevatorSelectionStrategy;
    }

    public void submitRequest(Request request) {
        ElevatorController elevatorController = elevatorSelectionStrategy.getOptimalElevator(request);
        elevatorController.acceptRequest(request);
    }
}
