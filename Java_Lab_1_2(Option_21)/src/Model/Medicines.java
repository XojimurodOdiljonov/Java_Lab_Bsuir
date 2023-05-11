package Model;

import java.io.Serializable;

public class Medicines implements Serializable {
    private int id;
    private String name;
    private String nameCompany;
    private String medicinesData;
    private int price;

    public Medicines(int id, String name, String nameCompany, String medicinesData, int price) {
        this.id = id;
        this.name = name;
        this.nameCompany = nameCompany;
        this.medicinesData = medicinesData;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getMedicinesData() {
        return medicinesData;
    }

    public void setMedicinesData(String medicinesData) {
        this.medicinesData = medicinesData;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + ", Название: " + getName() + ", Компания: " + getNameCompany() + "\n" +
                "Дата-Изготовления: " + getMedicinesData() + ", Цена: " + getPrice() + "$" + "\n";
    }
}
