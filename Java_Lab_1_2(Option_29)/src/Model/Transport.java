package Model;

import java.io.Serializable;

public class Transport implements Serializable {
    private String name;
    private int speed;
    private int interval;
    private boolean state;

    public Transport(boolean state) {
        this.state = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Название : " + getName() + "\n" + "Скорость: " + getSpeed() + "\n" + "Интервал: " + getInterval() + "\n";
    }
}
