package com.formation.lesfragments;

import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by tarikalaoui on 18/09/2017.
 */

public class Proprietaire implements Observer{

    private String name;
    private String lastName;

    public Animal animal;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Proprietaire(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public void update(Observable observable, Object o) {
        Log.i("TAG", observable.toString());
        if(observable instanceof Animal){
            Calendar calendar=new GregorianCalendar(Locale.FRANCE);
            Date date=calendar.getTime();
            this.animal = (Animal) observable;
        }
    }

    public String toString(){
        return String.format("%s %s \t%s", name, lastName, animal);
    }
}
