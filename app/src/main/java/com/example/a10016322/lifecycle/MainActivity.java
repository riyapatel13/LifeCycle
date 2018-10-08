package com.example.a10016322.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button counter;
    TextView showCounter;
    int x = 0;
    final String TAG = "COUNTER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = (Button)(findViewById(R.id.button_id));
        showCounter = (TextView)(findViewById(R.id.textView_id));

        if(savedInstanceState != null) { //piece of code has saved x
            x = savedInstanceState.getInt(TAG);
            showCounter.setText("Count: "+ x);
        }

        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x++;
                showCounter.setText("Count: "+ x);
            }
        });

    } //every time app rotates, it closes out and restarts

    @Override
    protected void onSaveInstanceState(Bundle outState) { //bundle - something you can save when you destroy the app
        super.onSaveInstanceState(outState);
        outState.putInt("COUNTER", x);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LIFECYCLE", "START"); //writes it in the log below
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFECYCLE", "RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFECYCLE", "PAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFECYCLE", "STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFECYCLE", "DESTROY");
    }
}
