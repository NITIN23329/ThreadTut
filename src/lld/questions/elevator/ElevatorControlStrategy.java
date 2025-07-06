package lld.questions.elevator;

import java.util.ArrayList;
import java.util.List;

public abstract class ElevatorControlStrategy {

    // a particular elevator must satisfy many requests, and how to fullfill is given by ElevatorControlStrategy
    List<Request> requestList;
    // it containst all the elevqtors and based on new request it gives the request to that particular elevator
    List<ElevatorController> elevatorControllerList;

    public ElevatorControlStrategy(List<ElevatorController> elevatorControllerList) {
        this.requestList = new ArrayList<>();
        this.elevatorControllerList = elevatorControllerList;
    }

    // instructor the elevator call to move in a certain order so that it satisy the requests
    abstract void moveElevator(ElevatorController elevatorController);

    public void deleteRequest(Request request) {
        this.requestList.remove(request);
    }
    public void acceptRequest(Request request) {
        this.requestList.add(request);
    }

}
