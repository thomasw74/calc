package calc.components;

import calc.events.DeleteTextEvent;
import javafx.scene.control.Button;

public final class DeleteKey extends Button {
    public DeleteKey() {
        super("←");
        setStyle("""
            -fx-font-size: 40;
            -fx-min-width: 100;
            -fx-min-height: 100;
        """);
        setOnAction(e -> fireEvent(new DeleteTextEvent()));
    }
}
