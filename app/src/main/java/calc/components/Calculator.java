package calc.components;

import calc.state.DisplayState;
import javafx.scene.layout.BorderPane;

import static calc.events.CalculateResultEvent.CALCULATE_RESULT;
import static calc.events.DeleteTextEvent.DELETE_TEXT;
import static calc.events.EnterTextEvent.ENTER_TEXT;

public final class Calculator extends BorderPane {
    private final DisplayState displayState = new DisplayState();

    public Calculator() {
        var display = new Display(displayState.textProperty());
        setTop(display);

        var keypad = new Keypad();
        keypad.addEventHandler(ENTER_TEXT, e -> displayState.addText(e.getText()));
        keypad.addEventHandler(DELETE_TEXT, e -> displayState.deleteText());
        keypad.addEventHandler(CALCULATE_RESULT, e -> displayState.calculateResult());
        setCenter(keypad);
    }
}
