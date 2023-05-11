package Model;

import java.io.Serializable;

public class Laboratories implements Serializable {
    private int id;
    private String facilities;
    private int price;

    public Laboratories(int id, String facilities, int price) {
        this.id = id;
        this.facilities = facilities;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + ", Оборудование: " + getFacilities() + ", Цена: " + getPrice() + "\n";
    }
}
