package com.formation.tpobservers;

import java.util.Observable;

/**
 * Created by tarikalaoui on 18/09/2017.
 */

public class Animal extends Observable{

    public String pseudo;


    @Override
    public String toString() {
        return pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
        setChanged();
        notifyObservers();
    }
}


