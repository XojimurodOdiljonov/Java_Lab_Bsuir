package Models;

import java.io.Serializable;

public class Credit implements Serializable{
    protected String name;
    private int price;

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

    @Override
    public String toString() {
        return "Назвние: " + getName() + " - " + "цена кредита: " + getPrice() + "$";
    }
}
