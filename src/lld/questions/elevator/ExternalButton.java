package lld.questions.elevator;

// this button is used to generate a call lift reqeust to externalDispatcher
public class ExternalButton extends Button {

    private ExternalDispatcher externalDispatcher;
    public ExternalButton(String buttonName, ExternalDispatcher externalDispatcher) {
        super(buttonName);
        this.externalDispatcher = externalDispatcher;
    }

    public void pressButton(int fromFloor, Direction direction) {
        externalDispatcher.submitRequest(new Request(fromFloor, direction));
    }
}
