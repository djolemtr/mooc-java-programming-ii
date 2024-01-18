package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    public void start(Stage window) {

        Canvas paintingCanvas = new Canvas(300, 320);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();

        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(paintingCanvas);

        painter.setFill(Color.BLACK);

        painter.fillRect(61, 37, 40, 40);
        painter.fillRect(200, 37, 40, 40);
        painter.fillRect(21, 150, 40, 40);
        painter.fillRect(240, 150, 40, 40);
        painter.fillRect(61, 190, 40, 40);
        painter.fillRect(101, 190, 40, 40);
        painter.fillRect(141, 190, 40, 40);
        painter.fillRect(181, 190, 40, 40);
        painter.fillRect(201, 190, 40, 40);

        Scene view = new Scene(paintingLayout);

        window.setScene(view);
        window.show();
    }

}
