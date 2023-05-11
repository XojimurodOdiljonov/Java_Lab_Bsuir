package Models;

import java.io.Serializable;

public class Flower implements Serializable, Comparable<Flower> {
    private String name;
    private int price;
    private int length;
    private String accessory;
    private int priceAccessory;

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public int getPriceAccessory() {
        return priceAccessory;
    }

    public void setPriceAccessory(int priceAccessory) {
        this.priceAccessory = priceAccessory;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Flower o) {
        return Integer.compare(this.getPrice(), o.getPrice());
    }

    @Override
    public String toString() {
        return "Название цветка: " + getName() + "\n" +
                "Цена цветка: " + getPrice() + "\n" +
                "Длина цветка: " + getLength() + "\n" +
                "Вид аксесуара: " + getAccessory() + "\n" +
                "Цена аксесуара: " + getPriceAccessory();
    }
}
