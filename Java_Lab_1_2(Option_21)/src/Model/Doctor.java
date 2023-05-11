package Model;

import java.io.Serializable;

public class Doctor implements Serializable {
    private int id;
    private String name;
    private String specialist;
    private String timeWork;
    private String roomDoctor;

    public Doctor(int id, String name, String specialist, String timeWork, String roomDoctor) {
        this.id = id;
        this.name = name;
        this.specialist = specialist;
        this.timeWork = timeWork;
        this.roomDoctor = roomDoctor;
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

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(String timeWork) {
        this.timeWork = timeWork;
    }

    public String getRoomDoctor() {
        return roomDoctor;
    }

    public void setRoomDoctor(String roomDoctor) {
        this.roomDoctor = roomDoctor;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + ", ФИО: " + getName() + ", Специальность: " + getSpecialist() + "\n" +
                "Время работы: " + getTimeWork() + "\n" +
                "Кабинет: " + getRoomDoctor() + "\n";
    }
}
