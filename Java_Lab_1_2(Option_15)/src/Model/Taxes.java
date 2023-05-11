package Model;

import java.io.Serializable;

public class Taxes implements Serializable, Comparable<Taxes>{
    private int id;
    private String FIO;
    private String typeTax;
    private int costTax;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getTypeTax() {
        return typeTax;
    }

    public void setTypeTax(String typeTax) {
        this.typeTax = typeTax;
    }

    public int getCostTax() {
        return costTax;
    }

    public void setCostTax(int costTax) {
        this.costTax = costTax;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " - " + getFIO() + ": Вид Налога: " + getTypeTax() + " - Налог: " + getCostTax() + "% " + "\n";
    }

    @Override
    public int compareTo(Taxes target) {
        return Integer.compare(this.getCostTax(), target.getCostTax());
    }
}
