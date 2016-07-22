package com.example.macuser.statusbardemo.model;

/**
 * Created by macuser on 16/7/22.
 **/
public class SongListModel {
    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getListname() {
        return listname;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    String imgurl;
    String listname;
    String playcount;
}