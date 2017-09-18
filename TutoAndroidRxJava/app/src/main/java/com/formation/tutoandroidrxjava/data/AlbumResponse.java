package com.formation.tutoandroidrxjava.data;

import com.formation.tutoandroidrxjava.models.Album;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tarikalaoui on 16/09/2017.
 */

public class AlbumResponse {
    @SerializedName("results")
    private List<Album> albumList;

    public List<Album> getAlbumList() {
        return albumList;
    }

}
