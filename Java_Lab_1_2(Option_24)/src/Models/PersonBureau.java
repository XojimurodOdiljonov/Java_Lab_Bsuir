package Models;

import java.io.Serializable;

public class PersonBureau implements Serializable {
    private String name;
    private int age;
    private String typeOfActivity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTypeOfActivity() {
        return typeOfActivity;
    }

    public void setTypeOfActivity(String typeOfActivity) {
        this.typeOfActivity = typeOfActivity;
    }

    @Override
    public String toString() {
        return "Имя: " + getName() + "\n" +
                "Возвраст: " + getAge() + "\n" +
                "Вид деятельности: " + getTypeOfActivity() + "\n";
    }
}
