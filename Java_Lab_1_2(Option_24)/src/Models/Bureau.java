package Models;

import java.io.Serializable;

public class Bureau implements Serializable {
    private String customerDeveloper;
    private String sourceOfFunding;
    private String typeOfConstruction;
    private String location;
    private int totalArea;
    private int price;

    public String getCustomerDeveloper() {
        return customerDeveloper;
    }

    public void setCustomerDeveloper(String customerDeveloper) {
        this.customerDeveloper = customerDeveloper;
    }

    public String getSourceOfFunding() {
        return sourceOfFunding;
    }

    public void setSourceOfFunding(String sourceOfFunding) {
        this.sourceOfFunding = sourceOfFunding;
    }

    public String getTypeOfConstruction() {
        return typeOfConstruction;
    }

    public void setTypeOfConstruction(String typeOfConstruction) {
        this.typeOfConstruction = typeOfConstruction;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(int totalArea) {
        this.totalArea = totalArea;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Заказчик застройчик: " + getCustomerDeveloper() + "\n" +
                "Источник финансирования: " + getSourceOfFunding() + "\n" +
                "Вид строительство: " + getTypeOfConstruction() + "\n" +
                "Адрес: " + getLocation() + "\n" +
                "Общая площадь: " + getTotalArea() + "га" + "\n" +
                "Стоимость: " + getPrice() + "$" +"\n";
    }
}
