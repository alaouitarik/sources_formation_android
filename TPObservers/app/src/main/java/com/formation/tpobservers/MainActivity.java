package com.formation.tpobservers;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.formation.tpobservers.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "MYObservers";

    public ActivityMainBinding activityMainBinding;

    public AnimalViewModel animalViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        animalViewModel = new AnimalViewModel(this);
        activityMainBinding.setAnimalViewModel(animalViewModel);

    }
}
