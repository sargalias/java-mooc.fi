package application;

import java.util.Random;

public class Thermometer implements Sensor {
    private boolean isOn = false;

    public Thermometer() {
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void on() {
        this.isOn = true;
    }

    @Override
    public void off() {
        this.isOn = false;
    }

    @Override
    public int measure() {
        Random random = new Random();
        return random.nextInt(61) - 30;
    }
}
