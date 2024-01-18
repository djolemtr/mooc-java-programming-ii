package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage window) {

        BorderPane view1 = new BorderPane();
        Label l1 = new Label("First View!");
        Button b1 = new Button("To the second view!");
        view1.setTop(l1);
        view1.setCenter(b1);

        Scene first = new Scene(view1);

        VBox view2 = new VBox();
        Label l2 = new Label("Second View!");
        Button b2 = new Button("To the third view!");
        view2.getChildren().add(b2);
        view2.getChildren().add(l2);
        

        Scene second = new Scene(view2);

        GridPane view3 = new GridPane();
        view3.add(new Label("Third view!"), 0, 0);
        Button b3 = new Button("To the first view!");
        view3.add(b3, 1, 1);

        Scene third = new Scene(view3);

        b1.setOnAction((event) -> {
            window.setScene(second);
        });

        b2.setOnAction((event) -> {
            window.setScene(third);
        });

        b3.setOnAction((event) -> {
            window.setScene(first);
        });

        window.setScene(first);
        window.show();
    }

}
