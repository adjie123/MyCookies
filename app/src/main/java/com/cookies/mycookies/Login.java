package com.cookies.mycookies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Lenovo on 20/08/2017.
 */

public class Login extends AppCompatActivity {

    private Button login;
    private EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        inputPassword = (EditText)findViewById(R.id.inputPw);
        login = (Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                String password = inputPassword.getText().toString();
                if(password.equals("unsika")){
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(Login.this, "Sorry, Your Password Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
