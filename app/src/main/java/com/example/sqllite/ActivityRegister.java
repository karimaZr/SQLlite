package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegister extends AppCompatActivity {
    EditText etUser,etPwd,etRepwd;
    Button btnRegister,btnGoToLogin;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUser=findViewById(R.id.username);
        etPwd=findViewById(R.id.password);
        etRepwd=findViewById(R.id.repassword);
        btnRegister=findViewById(R.id.btnRegister);
        btnGoToLogin=findViewById(R.id.btnLogin);
        btnGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityRegister.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        dbHelper=new DBHelper(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user,pwd,rePwd;
                user=etUser.getText().toString();
                pwd=etPwd.getText().toString();
                rePwd=etRepwd.getText().toString();
                if(user.equals("")||pwd.equals("")||rePwd.equals("")){
                    Toast.makeText(ActivityRegister.this,"Please fill all the fields ",Toast.LENGTH_LONG).show();
                }else {
                    if(pwd.equals(rePwd)){
                        if(dbHelper.checkUserName(user)){
                            Toast.makeText(ActivityRegister.this,"User already exists",Toast.LENGTH_LONG).show();
                        }
                        boolean registeredSucces=dbHelper.insetData(user,pwd);
                        if(registeredSucces){
                            Toast.makeText(ActivityRegister.this,"User Registred Succefully ",Toast.LENGTH_LONG).show();
                        }
                         else {
                            Toast.makeText(ActivityRegister.this,"User Registration Failed",Toast.LENGTH_LONG).show();
                        }

                    }else{
                        Toast.makeText(ActivityRegister.this,"Passwords de not match",Toast.LENGTH_LONG).show();
                    }
                }


            }
        });

    }
}