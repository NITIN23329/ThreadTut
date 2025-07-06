package lld.questions.elevator;

public class Display {
    Direction direction;
    int currentFloor;

    public Display() {
        this.direction = Direction.IDLE;
        currentFloor  = 0;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
