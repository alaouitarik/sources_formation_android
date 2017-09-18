package com.formation.tutoandroidrxjava.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class Album implements Serializable{

    @SerializedName("id") public String id;
    @SerializedName("albumid") public String albumid;
    @SerializedName("title") public String title;
    @SerializedName("url") public String  url;
    @SerializedName("thumbnailUrl") public String thumbnailUrl;

}
