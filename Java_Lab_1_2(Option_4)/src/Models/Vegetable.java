package Models;

import java.io.Serializable;

public class Vegetable implements Serializable, Comparable<Vegetable>{
    private String name;
    private int colorful;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColorful() {
        return colorful;
    }

    public void setColorful(int colorful) {
        this.colorful = colorful;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "Название продукта: " + getName() + "\n" +
                "Колорийность = " + getColorful() + "\n" +
                "Цена = " + getPrice() + " рубелей" + "\n";
    }

    @Override
    public int compareTo(Vegetable target) {
        return Integer.compare(this.getPrice(), target.getPrice());
    }
}
