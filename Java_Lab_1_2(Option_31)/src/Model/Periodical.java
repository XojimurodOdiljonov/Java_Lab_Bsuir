package Model;

import java.io.Serializable;

public class Periodical implements Serializable, Comparable<Periodical>{
    private String name;
    private int pages;
    private int year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Название издания: " + getName() + "\n   Количество страниц: " + getPages() + "\n   Год издания: " + getYear() + "\n";
    }

    @Override
    public int compareTo(Periodical target) {
        return Integer.compare(this.getYear(), target.getYear());
    }
}
