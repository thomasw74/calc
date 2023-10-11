package calc.components;

import calc.events.EnterTextEvent;
import javafx.scene.control.Button;

public final class TextKey extends Button {
    public TextKey(String text) {
        super(text);
        setStyle("""
            -fx-font-size: 40;
            -fx-min-width: 100;
            -fx-min-height: 100;
        """);
        setOnAction(e -> fireEvent(new EnterTextEvent(text)));
    }
}
