package Model;

public class User {
    private String name;
    private int age;
    private boolean condition;

    public User(boolean condition) {
        this.condition = false;
    }

    public boolean getCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

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
}
