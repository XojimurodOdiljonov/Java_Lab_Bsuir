package Model;

import java.io.Serializable;

public class Railway implements Serializable, Comparable<Railway>{
    private int id;
    private int bag;
    private int quantity;
    private int comfort;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getComfort() {
        return comfort;
    }

    public void setComfort(int comfort) {
        this.comfort = comfort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBag() {
        return bag;
    }

    public void setBag(int bag) {
        this.bag = bag;
    }

    @Override
    public String toString() {
        return "Id богажа = " + getId() + ", количество богажа: " + getBag() + "\nКоличество посажиров: " +
                getQuantity() + "\nУровень комфортности: " + getComfort();
    }

    @Override
    public int compareTo(Railway target) {
        return Integer.compare(this.getComfort(), target.getComfort());
    }
}
