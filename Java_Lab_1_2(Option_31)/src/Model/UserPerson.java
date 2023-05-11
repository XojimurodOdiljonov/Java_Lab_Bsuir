package Model;

public class UserPerson extends User{
    public UserPerson(boolean condition) {
        super(condition);
    }

    @Override
    public String toString() {
        return "Имя : " + getName() + "\n" + " Возраст: " + getAge() + "\n\n";
    }
}
