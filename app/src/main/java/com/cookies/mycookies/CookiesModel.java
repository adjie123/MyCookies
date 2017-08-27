package com.cookies.mycookies;

/**
 * Created by Lenovo on 16/08/2017.
 */

public class CookiesModel{

    private int id;
    private String judul;
    private String deskripsi;

    public  CookiesModel(int id, String judul, String deskripsi){
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
    }

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
