package com.zhangandrew.toastsharedprefsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textview1;
    TextView textview2;
    TextView textview3;
    TextView textview4;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        textview1 = findViewById(R.id.textBox1);
        textview2 = findViewById(R.id.textBox2);
        textview3 = findViewById(R.id.textBox3);
        textview4 = findViewById(R.id.textBox4);

        SeekBar seekBar =findViewById(R.id.seekbar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textview1.setTextSize(Float.valueOf(i));
                textview2.setTextSize(Float.valueOf(i));
                textview3.setTextSize(Float.valueOf(i));
                textview4.setTextSize(Float.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        View.OnClickListener event = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView x = (TextView)v;
                String a = x.getText().toString();
                int setting = sharedPreferences.getInt(a, 0);
                editor.putInt(a, setting+1);
                editor.apply();

                Context context = getApplicationContext();
                CharSequence text = a + ": " + sharedPreferences.getInt(a, 0);
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        };


        textview1.setOnClickListener(event);
        textview2.setOnClickListener(event);
        textview3.setOnClickListener(event);
        textview4.setOnClickListener(event);
    }
}