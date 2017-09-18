package com.formation.tutoandroidrxjava;

import android.app.Application;
import android.content.Context;

import com.formation.tutoandroidrxjava.data.AlbumFactory;
import com.formation.tutoandroidrxjava.data.AlbumService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tarikalaoui on 16/09/2017.
 */

public class AlbumApplication extends Application {


    private AlbumService albumService;
    private Scheduler scheduler;

    private static AlbumApplication get(Context context) {
        return (AlbumApplication) context.getApplicationContext();
    }

    public static AlbumApplication create(Context context) {
        return AlbumApplication.get(context);
    }

    public AlbumService getAlbumService() {
        if (albumService == null) {
            albumService = AlbumFactory.create();
        }
        return albumService;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }

        return scheduler;
    }

    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
