package Model;

import java.io.Serializable;

public class Patients implements Serializable {
    private int id;
    private String name;
    private String gender;
    private int age;

    public Patients(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + ", Имя: " + getName() + "\n" +
                "Пол: " + getGender() + ", Возвраст: " + getAge() + "\n";
    }
}
