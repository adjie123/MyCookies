package com.cookies.mycookies;

/**
 * Created by Lenovo on 16/08/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class EditActivity extends AppCompatActivity {

    private int position;
    private Button delete, save;
    private EditText inputJudul, inputDeskripsi;
    private String judul, deskripsi;
    private String ijudul, ideskripsi;
    private ArrayList<CookiesModel> data;
    private Helper helper;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_cookies);
        getSupportActionBar().setTitle("Modify Cookies");

        data = new ArrayList<>();
        helper = new Helper(EditActivity.this);

        position = getIntent().getIntExtra("id", 0);
        ijudul = getIntent().getStringExtra("judul");
        ideskripsi = getIntent().getStringExtra("deskripsi");


        inputJudul = (EditText) findViewById(R.id.inputJudul);
        inputDeskripsi = (EditText) findViewById(R.id.inputDeskripsi);

        inputJudul.setText(ijudul);
        inputDeskripsi.setText(ideskripsi);

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
            //mengambil teks
            judul = inputJudul.getText().toString();
            deskripsi = inputDeskripsi.getText().toString();

            //mengupdate data
            helper.updateCookies(position, judul, deskripsi);

            //berpindah actiivity
            startActivity(new Intent(EditActivity.this, MainActivity.class));
            finish();
            return true;
        }

        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
