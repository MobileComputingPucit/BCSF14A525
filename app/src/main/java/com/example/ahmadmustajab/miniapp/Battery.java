package com.example.ahmadmustajab.miniapp;

import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.content.IntentFilter;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ProgressBar;
        import android.widget.TextView;

public class Battery extends AppCompatActivity {
    private TextView t;
    private BroadcastReceiver br = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra("level", 0);
            ProgressBar pb=(ProgressBar)findViewById(R.id.bar);
            pb.setProgress(level);
            t.setText("Battery Level : " + Integer.toString(level) + "%");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);
        setTitle("BATTERY");
        t = (TextView) this.findViewById(R.id.textView5);
        this.registerReceiver(this.br,
                new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
