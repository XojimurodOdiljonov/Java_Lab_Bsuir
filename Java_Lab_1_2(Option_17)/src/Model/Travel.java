package Model;

import java.io.Serializable;

public class Travel implements Serializable, Comparable<Travel>{
    private String name;
    private String transport;
    private String powerSupply;
    private int day;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Вид путёвки: " + getName() + ", вид транспорта: " + getTransport() + ", вид питания: " + getPowerSupply() + ", насколько дней: " + getDay();
    }

    @Override
    public int compareTo(Travel target) {
        return Integer.compare(this.getDay(), target.getDay());
    }
}
