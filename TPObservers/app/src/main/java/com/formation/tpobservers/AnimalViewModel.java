package com.formation.tpobservers;

import android.content.Context;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.EditText;

import java.util.Observable;

/**
 * Created by tarikalaoui on 18/09/2017.
 */

public class AnimalViewModel extends Observable{

    private Animal animal;
    private Context context;

    private Proprietaire proprietaire;

    public AnimalViewModel(Context context) {
        this.context = context;

        animal = new Animal();

        proprietaire = new Proprietaire();
        proprietaire.setFirstName("test");

        animal.addObserver(proprietaire);
    }


    @Bindable
    public String getPseudo(){
        return animal.pseudo;
    }

    public void setPseudo(String pseudo){
        animal.setPseudo(pseudo);

    }

    @BindingAdapter("newPseudo")
    public void setNewPseudo(EditText editText, String libelle){
        animal.setPseudo(libelle);
    }

    public void addNewAnimal(View view){

    }

}
