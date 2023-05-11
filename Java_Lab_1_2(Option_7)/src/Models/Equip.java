package Models;

import java.io.Serializable;

public class Equip implements Serializable, Comparable<Equip>{
    private String name;
    private int price;
    private int weight;
    private String head;
    private String suit;
    private String pants;
    private String shoes;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getPants() {
        return pants;
    }

    public void setPants(String pants) {
        this.pants = pants;
    }

    public String getShoes() {
        return shoes;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }

    @Override
    public String toString() {
        return getName() + " " + "Цена: " + getPrice() +
                " Вес: " + getWeight() + "\n" + "Вид одежды: " + getHead() + " " + getSuit() + " " +
                getPants() + " " + getShoes() + "\n";
    }

    @Override
    public int compareTo(Equip o) {
        return Integer.compare(this.getWeight(), o.getWeight());
    }
}
