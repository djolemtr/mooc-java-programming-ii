package application;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        launch(PartiesApplication.class);

    }

    @Override
    public void start(Stage stage) {

        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        xAxis.setLabel("Year");
        yAxis.setLabel("Relative support (%)");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        //reading data into a hashmap
        Map<String, HashMap<Integer, Double>> data = new HashMap();

        try (Scanner scanner = new Scanner(Paths.get("partiesdata.tsv"))) {
            String line = scanner.nextLine();

            String[] years = line.split("	");

            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();

                String[] split = nextLine.split("	");

                HashMap<Integer, Double> temp = new HashMap();

                for (int i = 1; i < split.length; i++) {

                    if (!split[i].equals("-")) {
                        Double value = Double.valueOf(split[i]);
                        temp.put(Integer.valueOf(years[i]), value);

                    }

                }
                data.put(split[0], temp);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        data.keySet().stream().forEach(party -> {

            XYChart.Series dataF = new XYChart.Series();
            dataF.setName(party);

            data.get(party).entrySet().stream().forEach(pair -> {
                dataF.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            lineChart.getData().add(dataF);
        });

        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }
}
