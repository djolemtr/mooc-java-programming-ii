package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {

    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

    @Override
    public void start(Stage stage) {
        TextField newTF = new TextField("This is a text field.");
        Button b = new Button("Okur");
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(newTF);
        componentGroup.getChildren().add(b);

        Scene view = new Scene(componentGroup);

        stage.setScene(view);
        stage.show();
    }

}
