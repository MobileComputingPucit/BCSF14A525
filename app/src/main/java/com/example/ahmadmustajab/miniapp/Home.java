package com.example.ahmadmustajab.miniapp;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.security.Policy;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button b = (Button) findViewById(R.id.btn1);
        final WifiManager w = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!w.isWifiEnabled()) {
                    w.setWifiEnabled(true);
                    Toast.makeText(Home.this, "Wifi is Enabled", Toast.LENGTH_LONG).show();
                } else {
                    if (w.isWifiEnabled()) {
                        w.setWifiEnabled(false);
                        Toast.makeText(Home.this, "Wifi is Disabled", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
        Button b1 = (Button) findViewById(R.id.btn2);
        final BluetoothAdapter blue = BluetoothAdapter.getDefaultAdapter();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blue.isEnabled()) {
                    blue.disable();
                    Toast.makeText(Home.this, "Bluetooth is Disabled", Toast.LENGTH_LONG).show();
                } else {
                    if (!blue.isEnabled()) {
                        blue.enable();
                        Toast.makeText(Home.this, "Bluetooth is Enabled", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        Button b2=(Button)findViewById(R.id.btn3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Battery.class);
                startActivity(intent);
            }
        });
        Button b3=(Button)findViewById(R.id.btn4);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Sms.class);
                startActivity(intent);
            }
        });
    }
}





