package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {

    public void start(Stage window) {
        Label text = new Label("Button: ");

        Button b = new Button("This is a button.");

        FlowPane pane = new FlowPane();

        pane.getChildren().add(text);
        pane.getChildren().add(b);

        Scene view = new Scene(pane);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);

    }

}
