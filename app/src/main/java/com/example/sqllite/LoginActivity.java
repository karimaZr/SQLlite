package com.example.sqllite;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity  extends AppCompatActivity {
    Button btnlogin;
    EditText username,etPwd;
    DBHelper dbHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper=new DBHelper(this);
        username=findViewById(R.id.username);
        etPwd=findViewById(R.id.password);
        btnlogin=findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean islogged=dbHelper.checkUser(username.getText().toString(),etPwd.getText().toString());
                if(islogged){
                    Intent intent=new Intent(LoginActivity.this,MainActivity2.class);
                    startActivity(intent);
                }else
                    Toast.makeText(LoginActivity.this,"Login failed",Toast.LENGTH_LONG).show();

            }
        });
    }
}
