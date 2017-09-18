package com.formation.tpbindable.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.formation.tpbindable.R;
import com.formation.tpbindable.databinding.AlbumViewBinding;
import com.formation.tpbindable.model.Album;
import com.formation.tpbindable.viewmodel.AlbumViewModel;
import java.util.Observable;
import java.util.Observer;


public class MainActivity extends AppCompatActivity implements Observer {

    public static final String TAG = MainActivity.class.getSimpleName();

    AlbumViewBinding albumViewBinding;
    AlbumViewModel albumViewModel;
    Album album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBindings();
    }

    private void initDataBindings() {

        album = new Album();
        album.setTitle("");
        album.addObserver(this);
        albumViewBinding = DataBindingUtil.setContentView(this, R.layout.album_view);
        albumViewModel = new AlbumViewModel(album);
        albumViewBinding.setActivity(this);
        albumViewBinding.setAlbum(albumViewModel);
    }

    public void onButtonClick(String email){
        Log.d(TAG, "Pseudo :" + albumViewBinding.getAlbum().getTitle());
        Toast.makeText(this,email,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof Album){
            Log.i(TAG, album.toString());
        }
    }
}
