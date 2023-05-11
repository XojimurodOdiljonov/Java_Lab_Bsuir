package Models;

import java.io.Serializable;

public class Coffee implements Serializable, Comparable<Coffee>{
    private String name;
    private int price;
    private String total;

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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Название: " + getName() + "\n" + "Цена: " + getPrice() + "\n" + "Состав: " + getTotal();
    }

    @Override
    public int compareTo(Coffee target) {
        return Integer.compare(this.getPrice(), target.getPrice());
    }
}
