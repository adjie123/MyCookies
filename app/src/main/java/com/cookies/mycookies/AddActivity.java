package com.cookies.mycookies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

/**
 * Created by Lenovo on 16/08/2017.
 */

public class AddActivity extends AppCompatActivity{

    public Context context;
    public Realm realm;
    private EditText inputJudul, inputDeskripsi;
    private Button save;
    private Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_cookies);
        getSupportActionBar().setTitle("New Cookies");

        helper = new Helper(AddActivity.this);

        inputJudul = (EditText) findViewById(R.id.inputJudul);
        inputDeskripsi = (EditText) findViewById(R.id.inputDeskripsi);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is prsent.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_save){
            String judul, deskripsi;

            //mengambil teks dri edittext
            judul = inputJudul.getText().toString();
            deskripsi = inputDeskripsi.getText().toString();

            //menambah data kedb
            helper.addCookies(judul, deskripsi);

            finish();
            //kembali ke MainActivity
            Intent i = new Intent(AddActivity.this, MainActivity.class);
            startActivity(i);
            return true;
        }

        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
