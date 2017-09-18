package com.formation.tpbindable.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.formation.tpbindable.BR;
import com.formation.tpbindable.model.Album;

/**
 * Created by tarikalaoui on 18/09/2017.
 */

public class AlbumViewModel extends BaseObservable {

    Album album;
    public AlbumViewModel(Album album) {
        this.album = album;
    }
    @Bindable
    public String getTitle(){
        return album.title;
    }
    public void setTitle(String title){
        album.setTitle(title);
        notifyPropertyChanged(BR.title);
    }
}
