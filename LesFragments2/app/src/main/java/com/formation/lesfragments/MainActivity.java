package com.formation.lesfragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;

public class MainActivity extends FragmentActivity implements MainFragmentCallback {

    private static String TAG_LIST = "LIST";
    private static String TAG_DETAIL = "DETAIL";
    private static String TAG = "Fragments";
    private FragmentA fragmentA;
    private FragmentB fragmentB;
    private FragmentC fragmentC;
    private int cpt;
    FragmentManager fm;


    Proprietaire p;
    Animal a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cpt = 0;
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        fragmentC = new FragmentC();

        Bundle arguments = new Bundle();
        arguments.putInt("cpt", cpt);
        fragmentB.setArguments(arguments);

        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.list, fragmentA).commit();
        fm.beginTransaction().add(R.id.detail, fragmentB).commit();

        p = new Proprietaire("Tarik", "Alaoui");
        Log.i(TAG, p.toString());
        a = new Animal(String.format("Yoki %d", cpt));
        a.addObserver(p);

    }

    @Override
    public void onItemSelected(int itemId) {
        Log.i(TAG, "click @" + itemId);
        //((FragmentB) fragmentDetail).add(itemId);

        Fragment fragment = fm.findFragmentById(R.id.detail);
        if(fragment.equals(fragmentB)){
            Bundle arguments = new Bundle();
            arguments.putInt("cpt", ++cpt);
            fragmentB.setArguments(arguments);
            fm.beginTransaction().replace(R.id.detail, fragmentC).disallowAddToBackStack().commit();

            a.setSurname(String.format("Yoki %d", cpt));
            Log.i(TAG, p.toString());

        }else{
            fm.beginTransaction().replace(R.id.detail, fragmentB).disallowAddToBackStack().commit();
        }
    }
}
