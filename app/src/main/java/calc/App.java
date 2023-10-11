package calc;

import calc.components.Calculator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        var scene = new Scene(new Calculator());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
