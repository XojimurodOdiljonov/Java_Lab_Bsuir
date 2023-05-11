package Model;

import java.io.Serializable;

public class Insurance implements Serializable, Comparable<Insurance>{
    private String name;
    private int cost;
    private int risk;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    @Override
    public String toString() {
        return "Вид страхования: " + getName() + "\n" +
                "Сумма денег на страхования: " + getCost() + "\n" +
                "Процент риска: " + getRisk() + "%" + "\n";
    }

    @Override
    public int compareTo(Insurance target) {
        return Integer.compare(this.getRisk(), target.getRisk());
    }
}
