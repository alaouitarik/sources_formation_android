package com.formation.lesfragments;

import java.util.Observable;

/**
 * Created by tarikalaoui on 18/09/2017.
 */

public class Animal extends Observable {

    private String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        setChanged();
        notifyObservers();
    }

    public String toString(){
        return String.format("(animal : %s)", surname);
    }

    public Animal(String surname) {
        this.surname = surname;
       setChanged();
        notifyObservers();
    }
}
