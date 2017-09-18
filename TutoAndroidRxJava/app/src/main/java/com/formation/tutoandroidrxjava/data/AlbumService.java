package com.formation.tutoandroidrxjava.data;

import retrofit2.http.GET;
import retrofit2.http.Url;
import io.reactivex.Observable;

/**
 * Created by tarikalaoui on 16/09/2017.
 */

public interface AlbumService {

    @GET
    Observable<AlbumResponse> fetchAlbum(@Url String url);

}
