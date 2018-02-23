package com.example.lenovo.gsonparse;

/**
 * Created by lenovo on 2/16/2018.
 */

import com.google.gson.annotations.SerializedName;
public class ItemObject {
    @SerializedName("song_name")
    private String songTitle;
    @SerializedName("song_id")
    private String songYear;
    @SerializedName("artist_name")
    private String songAuthor;
    public ItemObject(String songTitle, String songYear, String songAuthor) {
        this.songTitle = songTitle;
        this.songYear = songYear;
        this.songAuthor = songAuthor;
    }
    public String getSongTitle() {
        return songTitle;
    }
    public String getSongYear() {
        return songYear;
    }
    public String getSongAuthor() {
        return songAuthor;
    }
}