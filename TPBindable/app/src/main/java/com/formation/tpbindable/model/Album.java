package com.formation.tpbindable.model;
import java.util.Observable;

public class Album extends Observable{

    public String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        setChanged();
        notifyObservers();
    }

    public String toString(){
        return this.title;
    }
}
