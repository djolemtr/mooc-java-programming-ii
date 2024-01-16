package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean isOn;

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void setOn() {
        this.isOn = true;

    }

    @Override
    public void setOff() {
        this.isOn = false;

    }

    @Override
    public int read() {
        int random = new Random().nextInt(61);

        if (this.isOn()) {

            if (random > 30) {
                random = random - 30;
            } else {
                random = random - 30;
            }

        } else {
            throw new IllegalStateException();
        }
        return random;
    }

}