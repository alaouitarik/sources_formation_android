package com.formation.tpobservers;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by tarikalaoui on 18/09/2017.
 */

public class Proprietaire implements Observer{

    public String firstName;
    public String lastName;

    public Animal animal;

    @Override
    public void update(Observable observable, Object o) {

        Log.i(MainActivity.TAG, observable.toString());

    }
    @Override
    public String toString() {
        return String.format("%s %s : %s", firstName, lastName, animal);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

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
}
