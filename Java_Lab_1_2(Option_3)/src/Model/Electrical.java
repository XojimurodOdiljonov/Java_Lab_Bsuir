package Model;

import java.io.Serializable;

public class Electrical implements Serializable, Comparable<Electrical>{
    private String name;
    private int price;
    private int power;
    private boolean condition;

    public Electrical(boolean condition) {
        this.condition = false;
    }

    public boolean getCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Названия продукта: " + getName() + ", Цена: " + getPrice() + "$, Мощность: " + getPower();
    }

    @Override
    public int compareTo(Electrical target) {
        return Integer.compare(this.getPower(), target.getPower());
    }
}
