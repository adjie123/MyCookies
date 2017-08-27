package com.cookies.mycookies;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Lenovo on 16/08/2017.
 */

public class Cookies extends RealmObject {

    @PrimaryKey
    private int id;
    private String judul;
    private String deskripsi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }



}
