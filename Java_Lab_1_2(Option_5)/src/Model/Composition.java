package Model;

import java.io.Serializable;

public class Composition implements Serializable {
    private String nameAlbum;
    private int timeMusic;

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public int getTimeMusic() {
        return timeMusic;
    }

    public void setTimeMusic(int timeMusic) {
        this.timeMusic = timeMusic;
    }
    @Override
    public String toString() {
        return "Названия альбома: " + getNameAlbum() + ", продолжительность: " + getTimeMusic() + " - минут";
    }
}
