package calc.components;

import calc.events.CalculateResultEvent;
import javafx.scene.control.Button;

public final class CalculateKey extends Button {
    public CalculateKey() {
        super("=");
        setStyle("""
            -fx-font-size: 40;
            -fx-min-width: 100;
            -fx-min-height: 100;
        """);
        setOnAction(e -> fireEvent(new CalculateResultEvent()));
    }
}
