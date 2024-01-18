package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane layout = new BorderPane();

        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator");

        layout.setCenter(lineChart);

        VBox topComp = new VBox();
        topComp.setPadding(new Insets(20, 20, 20, 20));
        topComp.setSpacing(10);

        layout.setTop(topComp);

        BorderPane tCFirst = new BorderPane();
        BorderPane tCSecond = new BorderPane();

        Label TCFLabelLeft = new Label("Monthly savings");

        Slider topSlider = new Slider(25, 250, 0);
        topSlider.setShowTickLabels(true);
        topSlider.setShowTickMarks(true);
        Label topSliderLabel = new Label();
        topSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {

                topSliderLabel.setText(String.format("%.1f", new_val));

            }
        });

        XYChart.Series noIntSeries = new XYChart.Series();
        updateChart(25, noIntSeries, 0);
        lineChart.getData().add(noIntSeries);

        XYChart.Series withIntSeries = new XYChart.Series();
        lineChart.getData().add(withIntSeries);

        tCFirst.setLeft(TCFLabelLeft);
        tCFirst.setCenter(topSlider);
        tCFirst.setRight(topSliderLabel);

        Label TCSLabelLeft = new Label("Yearly interest rate");

        Slider bttmSlider = new Slider(0, 10, 0);
        bttmSlider.setShowTickLabels(true);
        bttmSlider.setShowTickMarks(true);
        Label bttmSliderLabel = new Label();
        bttmSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {

                bttmSliderLabel.setText(String.format("%.1f", new_val));

            }

        });

        topSlider.valueProperty().addListener((obs, oldValue, newValue) -> {
            updateChart(newValue.doubleValue(), noIntSeries, 0);

        });

        bttmSlider.valueProperty().addListener((obs, oldValue, newValue) -> {
            updateChart(topSlider.getValue(), withIntSeries, newValue.doubleValue());

        });

        tCSecond.setLeft(TCSLabelLeft);
        tCSecond.setCenter(bttmSlider);
        tCSecond.setRight(bttmSliderLabel);

        topComp.getChildren().add(tCFirst);
        topComp.getChildren().add(tCSecond);

        Scene view = new Scene(layout);

        stage.setScene(view);
        stage.show();

    }

    public void updateChart(double amount, XYChart.Series data, double interestRate) {
        data.getData().clear();

        if (interestRate == 0) {
            for (int i = 0; i < 31; i++) {

                double yearlySaving = (i * 12) * amount;

                data.getData().add(new XYChart.Data(i, yearlySaving));

            }
        } else {

            double newAmount = amount;

            for (int i = 0; i < 31; i++) {

                newAmount = newAmount + (newAmount * interestRate / 100);

                double yearlySaving = (i * 12) * newAmount;

                data.getData().add(new XYChart.Data(i, yearlySaving));
                
            }
        }

    }

}
