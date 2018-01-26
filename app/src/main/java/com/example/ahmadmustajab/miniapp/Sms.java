package com.example.ahmadmustajab.miniapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sms extends AppCompatActivity {
    EditText text, phone, amount;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        setTitle("SMS");
        text = (EditText) findViewById(R.id.txt1);
        phone = (EditText) findViewById(R.id.txt2);
        amount = (EditText) findViewById(R.id.txt3);
        b = (Button) findViewById(R.id.btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendsms();
            }
        });
    }

    public void sendsms() {
        String p = phone.getText().toString();
        String t = text.getText().toString();
        String a = amount.getText().toString();
        int num =  Integer.parseInt(a);
        try {
            for (int i = 0; i <num ; i++) {
                SmsManager s = SmsManager.getDefault();
                s.sendTextMessage(p, null, t, null, null);
                int d = i+1;
                Toast.makeText(Sms.this, "Sms Send "+d, Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(Sms.this, "Sms Send Failed", Toast.LENGTH_SHORT).show();
        }
        text.setText("");
        phone.setText("");
        amount.setText("");
    }
}
