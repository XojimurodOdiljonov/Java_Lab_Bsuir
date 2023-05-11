package Model;

import java.io.Serializable;

public class Passenger implements Serializable {
    private String stationTerminal;
    private String timePassenger;
    private String dateTrip;

    public Passenger(String stationTerminal, String timePassenger, String dateTrip) {
        this.stationTerminal = stationTerminal;
        this.timePassenger = timePassenger;
        this.dateTrip = dateTrip;
    }

    public String getStationTerminal() {
        return stationTerminal;
    }

    public void setStationTerminal(String stationTerminal) {
        this.stationTerminal = stationTerminal;
    }

    public String getTimePassenger() {
        return timePassenger;
    }

    public void setTimePassenger(String timePassenger) {
        this.timePassenger = timePassenger;
    }

    public String getDateTrip() {
        return dateTrip;
    }

    public void setDateTrip(String dateTrip) {
        this.dateTrip = dateTrip;
    }

    @Override
    public String toString() {
        return "Выбранная конечная станция: " + getStationTerminal() + "\n" +
                "Время поездки пассажира: " + getTimePassenger() + "\n" +
                "Дата поездки пассажира: " + getDateTrip();
    }
}
