package Model;

import java.io.Serializable;

public class Airline implements Serializable, Comparable<Airline>{
    private String name;
    private int price;
    private int capacity;
    private int loadCapacity;
    private int flightRange;
    private int gasolineConsumption;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(int flightRange) {
        this.flightRange = flightRange;
    }

    public int getGasolineConsumption() {
        return gasolineConsumption;
    }

    public void setGasolineConsumption(int gasolineConsumption) {
        this.gasolineConsumption = gasolineConsumption;
    }

    @Override
    public String toString() {
        return "Названия самолета: " + getName() + "\n"
                + "Цена: " + getPrice() + "\n"
                + "Общая вместимость: " + getCapacity() + "\n"
                + "Общая грузоподъемность: " + getLoadCapacity() + "\n"
                + "Дальность: " + getFlightRange() + "\n"
                + "Расход бензина: " + getGasolineConsumption();
    }

    @Override
    public int compareTo(Airline target) {
        return Integer.compare(this.getFlightRange(), target.getFlightRange());
    }
}
