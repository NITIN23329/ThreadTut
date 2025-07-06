package lld.questions.elevator;

public class InternalButton extends Button {

    private InternalDispatcher internalDispatcher;

    public InternalButton(String buttonName) {
        super(buttonName);
    }

    public void pressButton(int toFloor, Direction direction, int elevatorId) {
        this.internalDispatcher.submitRequest(new Request(toFloor, direction), elevatorId);
    }
}
