package Models;

import java.io.Serializable;

public class Library implements Serializable{
    private int Id;
    private String name;
    private int pages;

    @Override
    public String toString() {
        return "ID Книги: " + getId() + ", Название книги: " + getName() + ", страниц: " + getPages();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

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

}
