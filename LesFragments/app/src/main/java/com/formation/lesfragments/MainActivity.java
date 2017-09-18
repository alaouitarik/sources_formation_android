package com.formation.lesfragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends FragmentActivity implements MainFragmentCallback {

    private static String TAG_LIST = "LIST";
    private static String TAG_DETAIL = "DETAIL";
    private static String TAG = "Fragments";
    private Fragment fragmentList;
    private Fragment fragmentDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentList = getSupportFragmentManager().findFragmentByTag(TAG_LIST);
        fragmentDetail = getSupportFragmentManager().findFragmentByTag(TAG_DETAIL);

    }

    @Override
    public void onItemSelected(int itemId) {
        Log.i(TAG, "click @" + itemId);
        ((FragmentB) fragmentDetail).add(itemId);
    }
}
