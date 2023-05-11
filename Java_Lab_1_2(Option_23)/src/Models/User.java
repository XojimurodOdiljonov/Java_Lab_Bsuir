package Models;

public class User extends Person{
    public User(boolean condition) {
        super(condition);
    }

    @Override
    public String toString() {
        return "Имя пользователя: " + getName() + ", возвраст: " + getAge();
    }
}
