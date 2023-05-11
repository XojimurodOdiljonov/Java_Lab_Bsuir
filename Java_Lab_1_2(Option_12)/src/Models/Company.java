package Models;

import java.io.Serializable;

public class Company implements Serializable {
    private String name;
    private int number;
    private int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Имя абонимента: " + getName() + "\n" +
                "Номер: " + getNumber() + "\n" +
                "Минуты: " + getTime() + "\n";
    }
}
