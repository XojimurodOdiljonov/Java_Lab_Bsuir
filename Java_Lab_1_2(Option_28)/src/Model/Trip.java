package Model;

import java.io.Serializable;

public class Trip implements Serializable {
    private String numberTrain;
    private String timeTrain;
    private String terminalStation;
    private int priceTrip;

    public String getNumberTrain() {
        return numberTrain;
    }

    public void setNumberTrain(String numberTrain) {
        this.numberTrain = numberTrain;
    }

    public String getTimeTrain() {
        return timeTrain;
    }

    public void setTimeTrain(String timeTrain) {
        this.timeTrain = timeTrain;
    }

    public String getTerminalStation() {
        return terminalStation;
    }

    public void setTerminalStation(String terminalStation) {
        this.terminalStation = terminalStation;
    }

    public int getPriceTrip() {
        return priceTrip;
    }

    public void setPriceTrip(int priceTrip) {
        this.priceTrip = priceTrip;
    }

    @Override
    public String toString() {
        return "Номер Поезда: " + getNumberTrain() + "\n" +
                "Время-поездки: " + getTimeTrain() + "\n" +
                "Конечная станция: " + getTerminalStation() + "\n" +
                "Цена: " + getPriceTrip() + " - ₽";
    }
}
