package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();

    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        boolean isOn = true;
        for (Sensor s : this.sensors) {
            if (!s.isOn()) {
                isOn = false;
            }
        }

        return isOn;
    }

    @Override
    public void setOn() {
        for (Sensor s : this.sensors) {
            s.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor s : this.sensors) {
            s.setOff();
        }
    }

    @Override
    public int read() {
        int sum = 0;
        if (!this.sensors.isEmpty() || this.isOn()) {
            for (Sensor s : this.sensors) {
                sum += s.read();

            }
            int average = sum / this.sensors.size();
            this.readings.add(average);
            return average;
        } else {
            throw new IllegalStateException();
        }

    }

    public List<Integer> readings() {
        return this.readings;

    }
}
