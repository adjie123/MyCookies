package com.cookies.mycookies;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Helper helper;
    private ArrayList<CookiesModel> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();
        helper = new Helper(MainActivity.this);

        recyclerView = (RecyclerView)findViewById(R.id.rcCookies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddActivity.class));
            }
        });


        setRecyclerView();
    }

    public void setRecyclerView(){
        try{
            data = helper.findAllCookies();
        }catch (Exception e){
            e.printStackTrace();
        }
        CookiesAdapter adapter = new CookiesAdapter(data, new CookiesAdapter.OnItemClickListener(){

            @Override
            public void onClick(final CookiesModel item){
                final CharSequence[] dialogitem = {"Modify Cookie", "Delete Cookie"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Option");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int option) {
                        switch (option) {
                            case 0:
                                Intent i = new Intent(getApplicationContext(), EditActivity.class);
                                i.putExtra("id", item.getId());
                                i.putExtra("judul", item.getJudul());
                                i.putExtra("deskripsi", item.getDeskripsi());
                                startActivity(i);
                                break;

                            case 1:
                                //menghapus data
                                helper.deleteCookies(item.getId());
                                onResume();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume(){
        super.onResume();
        try{
            data = helper.findAllCookies();
        }catch (Exception e){
            e.printStackTrace();
        }

        setRecyclerView();
    }


}
