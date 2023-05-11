package Models;

import java.io.Serializable;

public class Candies implements Serializable, Comparable<Candies> {
    protected String name;
    private int sugar;
    private int scale;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "Название конфеты: " + getName() + "\n" +
                "Количество сахара: " + getSugar() + "\n" +
                "Вес конфеты: " + getScale() + "\n";
    }
    @Override
    public int compareTo(Candies target) {
        return Integer.compare(this.getSugar(), target.getSugar());
    }
}
