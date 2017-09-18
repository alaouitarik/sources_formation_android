package com.formation.tutoandroidrxjava.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.formation.tutoandroidrxjava.models.Album;

import java.util.Observable;

/**
 * Created by tarikalaoui on 16/09/2017.
 */

public class ItemAlbumViewModel extends BaseObservable {

    private Album album;
    private Context context;

    public ItemAlbumViewModel(Album album, Context context) {
        this.album = album;
        this.context = context;
    }

    public String getTitle() {
        return album.title;
    }

    public String getUrl() {
        return album.url;
    }

    public String getThumbnail(){
        return album.thumbnailUrl;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    public void onItemClick(View view) {

    }

    public void setAlbum(Album album) {
        this.album = album;
        notifyChange();
    }
}
