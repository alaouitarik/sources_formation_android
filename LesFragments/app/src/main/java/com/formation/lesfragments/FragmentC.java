package com.formation.lesfragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tarikalaoui on 18/09/2017.
 */

public class FragmentC extends Fragment {
    private MainFragmentCallback parent;

    @Override
    public void onAttach(Activity activity) {
        Log.w("MainFragmentHC", "onAttach called");
        super.onAttach(activity);
        // Utiliser cette méthode pour lier votre fragment avec son callback
        parent = (MainFragmentCallback) activity;
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c, container, false);


        //Instancier vos composants graphique ici (faîtes vos findViewById)


        return view;
    }


}
