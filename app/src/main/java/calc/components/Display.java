package calc.components;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public final class Display extends BorderPane {
    public Display(ReadOnlyStringProperty textProperty) {
        var textControl = new Text();
        textControl.textProperty().bind(textProperty);
        textControl.setStyle("""
                -fx-font-size: 40;
                -fx-text-alignment: right;
                """);

        setRight(textControl);
        setStyle("""
                -fx-background-color: lightgoldenrodyellow;
                """);
    }
}
