package com.example.ahmadmustajab.miniapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        ss();
    }
    public void ss(){
        Thread t=new Thread(){
            public void run(){
                try{
                    sleep(1*2000);
                    Intent intent=new Intent(Splash.this,Home.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){
            }
        }

    };
    t.start();
}}
