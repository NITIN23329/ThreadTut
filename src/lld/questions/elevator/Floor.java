package lld.questions.elevator;

import java.util.List;

public class Floor {
    private int floor;
    private Display display;
    private List<Button> buttonList;

    public Floor(int floor, Display display, List<Button> buttonList) {
        this.floor = floor;
        this.display = display;
        this.buttonList = buttonList;
    }
}
