package Model;

import java.io.Serializable;

public class Stone implements Serializable, Comparable<Stone>{
    private String name;
    private int weightStone;
    private int priceStone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeightStone() {
        return weightStone;
    }

    public void setWeightStone(int weightStone) {
        this.weightStone = weightStone;
    }

    public int getPriceStone() {
        return priceStone;
    }

    public void setPriceStone(int priceStone) {
        this.priceStone = priceStone;
    }

    @Override
    public String toString() {
        return "Вид камня: " + getName() + "\n" +
                "Весс: " + getWeightStone() + " в каратах" +  "\n" +
                 "Цена: " + getPriceStone() + "$" + "\n";
    }

    @Override
    public int compareTo(Stone target) {
        return Integer.compare(this.getPriceStone(), target.getPriceStone());
    }
}
