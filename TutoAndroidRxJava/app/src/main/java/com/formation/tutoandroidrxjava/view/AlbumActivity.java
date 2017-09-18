package com.formation.tutoandroidrxjava.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.formation.tutoandroidrxjava.R;
import com.formation.tutoandroidrxjava.databinding.AlbumActivityBinding;
import com.formation.tutoandroidrxjava.viewmodel.AlbumViewModel;

import java.util.Observable;
import java.util.Observer;

public class AlbumActivity extends AppCompatActivity implements Observer {

    private AlbumActivityBinding albumActivityBinding;
    private AlbumViewModel albumViewModel;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();
        setupListAlbumView(albumActivityBinding.listAlbum);
        setupObserver(albumViewModel);
    }



    private void initDataBinding() {
        albumActivityBinding = DataBindingUtil.setContentView(this, R.layout.album_activity);
        albumViewModel = new AlbumViewModel(this);
        albumActivityBinding.setMainViewModel(albumViewModel);
    }

    private void setupListAlbumView(RecyclerView listAlbum) {
        AlbumAdapter adapter = new AlbumAdapter();
        listAlbum.setAdapter(adapter);
        listAlbum.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
        albumViewModel.initializeViews();
        albumViewModel.fetchAlbumList();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        albumViewModel.reset();
    }


    @Override public void update(Observable observable, Object data) {
        if (observable instanceof AlbumViewModel) {
            AlbumAdapter adapter = (AlbumAdapter) albumActivityBinding.listAlbum.getAdapter();
            AlbumViewModel albumViewModel = (AlbumViewModel) observable;
            adapter.setAlbumList(albumViewModel.getAlbumList());
        }
    }

}
