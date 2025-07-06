package lld.questions.elevator;

import java.util.List;

public class ScanElevatorControlStrategy extends ElevatorControlStrategy {
    boolean moveUp = true;
    public ScanElevatorControlStrategy(List<ElevatorController> elevatorControllerList) {
        super(elevatorControllerList);
    }

    List<Request> requestList;
    // it containst all the elevqtors and based on new request it gives the request to that particular elevator
    List<ElevatorController> elevatorControllerList;


    @Override
    void moveElevator(ElevatorController elevatorController) {
        int currFloor = elevatorController.getElevatorCar().getDisplay().currentFloor;
        if(moveUp) {
            requestList.sort((a,b)-> (a.getFloor()-b.getFloor()));
            boolean found = false;
            for(int i = 0;i<requestList.size();i++) {
                if(requestList.get(i).getFloor()>=currFloor) {
                    elevatorController.getElevatorCar().move(requestList.get(i));
                    requestList.remove(i);
                    found = true;
                    break;
                }

            }
            if(!found) {moveUp = !moveUp;}

        }else {
            requestList.sort((a,b)-> (b.getFloor()-a.getFloor()));
            boolean found = false;
            for(int i = 0;i<requestList.size();i++) {
                if(requestList.get(i).getFloor()<=currFloor) {
                    elevatorController.getElevatorCar().move(requestList.get(i));
                    found = true;
                }

            }
            if(!found) {moveUp = !moveUp;}
        }

    }
}
