package lld.questions.elevator;

import java.util.List;

// this dispatcher is used to submit a request to particular elevator internally
public class InternalDispatcher extends Dispatcher {

    private List<ElevatorController> elevatorControllerList;

    public InternalDispatcher(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }

    public void submitRequest(Request request, int elevatorId){

        for(ElevatorController elevatorController : elevatorControllerList){
            if(elevatorController.getElevatorCar().getId() == elevatorId){
                elevatorController.acceptRequest(request);
            }
        }

    }
}
