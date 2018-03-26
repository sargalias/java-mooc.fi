package application;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors = new ArrayList<Sensor>();
    private List<Integer> readings = new ArrayList<Integer>();

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : this.sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for (Sensor sensor : this.sensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : this.sensors) {
            sensor.off();
        }
    }

    @Override
    public int measure() throws IllegalStateException {
        int sum = 0;
        for (Sensor sensor : this.sensors) {
            sum += sensor.measure();
        }
        int avg = sum / this.sensors.size();
        this.readings.add(avg);
        return avg;
    }

    public List<Integer> readings() {
        return this.readings;
    }
}
