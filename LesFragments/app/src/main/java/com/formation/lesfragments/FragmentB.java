package com.formation.lesfragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tarikalaoui on 18/09/2017.
 */

public class FragmentB extends Fragment {
    private MainFragmentCallback parent;
    private TextView info;
    private int cpt;

    @Override
    public void onAttach(Activity activity) {
        Log.w("MainFragmentHC", "onAttach called");
        super.onAttach(activity);
        // Utiliser cette méthode pour lier votre fragment avec son callback
        parent = (MainFragmentCallback) activity;
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.setRetainInstance(true);
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        info = view.findViewById(R.id.libelle);

        info.setText(String.format("%d", cpt));
        return view;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("cpt", cpt);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState != null)
            cpt = savedInstanceState.getInt("cpt");
    }

    public void add(int nb){
        cpt++;
        info.setText(String.format("%d", cpt));

    }




}
