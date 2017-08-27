package com.cookies.mycookies;

import android.app.Application;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by Lenovo on 20/08/2017.
 */

public class BaseApp extends Application {
    private Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();
        //kode konfigurasi Realm
        RealmConfiguration config = new RealmConfiguration.Builder(this)
                //versi database
                .schemaVersion(0)
                .migration(new DataMigration())
                .build();

        Realm.setDefaultConfiguration(config);

    }

    private class DataMigration implements RealmMigration {
        @Override
        public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

            //Mengambil schema
            RealmSchema schema = realm.getSchema();

            //membuat schema baru jika versi 0
            if (oldVersion == 0) {
                schema.create("Cookies")
                        .addField("id", int.class)
                        .addField("judul", String.class)
                        .addField("deskripsi", String.class);
                oldVersion++;
            }

        }
    }
}