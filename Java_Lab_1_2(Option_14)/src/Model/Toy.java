package Model;

import java.io.Serializable;

public class Toy implements Serializable, Comparable<Toy>{
    private String name;
    private String size;
    private int cost;
    private int age;

    public Toy(String name, String size, int cost, int age) {
        this.name = name;
        this.size = size;
        this.cost = cost;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Имя продукта = " + getName() + " Размер: " + getSize() +
                ", Цена: " + getCost() + "$, " + "Возвраст: " + getAge();
    }

    @Override
    public int compareTo(Toy target) {
        return Integer.compare(this.getCost(), target.getCost());
    }
}
