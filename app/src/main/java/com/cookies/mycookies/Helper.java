package com.cookies.mycookies;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by Lenovo on 16/08/2017.
 */

public class Helper {

    private final String TAG = "Helper";

    public Context context;
    private Realm realm;
    private RealmResults<Cookies> realmResults;

    public Helper(Context context){
        realm = Realm.getInstance(context);
        this.context = context;
    }


    //Method Tambah
    public void addCookies(String judul, String deskripsi){
        realm.beginTransaction();
        Cookies cookies = realm.createObject(Cookies.class);
        cookies.setId((int) (System.currentTimeMillis() / 1000));
        cookies.setJudul(judul);
        cookies.setDeskripsi(deskripsi);
        realm.commitTransaction();

        showToast(judul + " Berhasil disimpan.");
    }


    //Method Pencarian
    public ArrayList<CookiesModel> findAllCookies(){
        ArrayList<CookiesModel> data = new ArrayList<>();

        realmResults = realm.where(Cookies.class).findAll();
        realmResults.sort("id", Sort.DESCENDING);
        if(realmResults.size() > 0){
            showLog("Size" + realmResults.size());

            for (int i = 0; i < realmResults.size(); i++){
                String judul, deskripsi;
                int id = realmResults.get(i).getId();
                judul = realmResults.get(i).getJudul();
                deskripsi = realmResults.get(i).getDeskripsi();
                data.add(new CookiesModel(id, judul, deskripsi));
            }
        }

        else{
            showLog("Size : 0");
            showToast("Data Kosong");
        }

        return data;
    }


    //Method Update
    public void updateCookies(int id, String judul, String deskripsi){
        realm.beginTransaction();
        Cookies cookies = realm.where(Cookies.class).equalTo("id", id).findFirst();
        cookies.setJudul(judul);
        cookies.setDeskripsi(deskripsi);
        realm.commitTransaction();

        showLog("Updated : " + judul);
        showToast(judul + " Berhasil diupdate.");
    }


    //Method Menghapus
    public void deleteCookies(int id){
        RealmResults<Cookies> dataResults = realm.where(Cookies.class).equalTo("id", id).findAll();
        realm.beginTransaction();
        dataResults.remove(0);
        dataResults.removeLast();
        realm.commitTransaction();

        showToast("Berhasil Menghapus");
    }


    //Membuat Log
    private void showLog(String s){
        Log.d(TAG, s);
    }

    //Mebuat Toast
    private void showToast(String s){
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
