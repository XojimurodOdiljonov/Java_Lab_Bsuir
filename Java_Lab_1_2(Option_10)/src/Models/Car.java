package Models;

import java.io.Serializable;

public class Car implements Serializable, Comparable<Car>{
    protected String name;
    private int price;
    private int speed;
    private int oil;

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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getOil() {
        return oil;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    @Override
    public String toString() {
        return "Назвние машины: " + getName() + "\n" +
                "Цена: " + getPrice() + "$" + "\n" +
                "Скорость: " + getSpeed() + "\n" +
                "Расход топливы: " + getOil();
    }

    @Override
    public int compareTo(Car target) {
        return Integer.compare(this.getOil(), target.getOil());
    }
}
