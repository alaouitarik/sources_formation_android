package com.formation.tutoandroidrxjava.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;

import com.formation.tutoandroidrxjava.AlbumApplication;
import com.formation.tutoandroidrxjava.R;
import com.formation.tutoandroidrxjava.data.AlbumFactory;
import com.formation.tutoandroidrxjava.data.AlbumResponse;
import com.formation.tutoandroidrxjava.data.AlbumService;
import com.formation.tutoandroidrxjava.models.Album;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by tarikalaoui on 16/09/2017.
 */

public class AlbumViewModel  extends Observable {

    public ObservableInt albumProgress;
    public ObservableInt albumRecycler;
    public ObservableInt albumLabel;
    public ObservableField<String> messageLabel;

    private List<Album> albumList;
    private Context context;


    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public AlbumViewModel(@NonNull Context context) {

        this.context = context;
        this.albumList = new ArrayList<>();
        albumProgress = new ObservableInt(View.GONE);
        albumRecycler = new ObservableInt(View.GONE);
        albumLabel = new ObservableInt(View.VISIBLE);
        messageLabel = new ObservableField<>(context.getString(R.string.loading));
    }


    public void onClickFabLoad(View view) {
        initializeViews();
        fetchAlbumList();
    }

    //It is "public" to show an example of test
    public void initializeViews() {
        albumLabel.set(View.GONE);
        albumRecycler.set(View.GONE);
        albumProgress.set(View.VISIBLE);

    }

    public void fetchAlbumList() {

        AlbumApplication albumApplication = AlbumApplication.create(context);
        AlbumService albumService = albumApplication.getAlbumService();

            Disposable disposable = albumService.fetchAlbum(AlbumFactory.ALBUM_URL)
                    .subscribeOn(albumApplication.subscribeScheduler())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<AlbumResponse>() {
                        @Override
                        public void accept(AlbumResponse albumResponse) throws Exception {
                            changeAlbumDataSet(albumResponse.getAlbumList());
                            albumProgress.set(View.GONE);
                            albumLabel.set(View.GONE);
                            albumRecycler.set(View.VISIBLE);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            Log.e("Albums", throwable.getMessage().toString());
                            messageLabel.set(context.getString(R.string.error_loading_album));
                            albumProgress.set(View.GONE);
                            albumLabel.set(View.VISIBLE);
                            albumRecycler.set(View.GONE);
                        }
                    });
            compositeDisposable.add(disposable);
    }

    private void changeAlbumDataSet(List<Album> albums) {
        albumList.clear();
        albumList.addAll(albums);
        setChanged();
        notifyObservers();
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void reset() {
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }
}
