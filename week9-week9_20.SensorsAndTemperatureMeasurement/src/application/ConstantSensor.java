package application;

public class ConstantSensor implements Sensor {
    private int temp;

    public ConstantSensor(int temp) {
        this.temp = temp;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    @Override
    public int measure() {
        return this.temp;
    }
}
