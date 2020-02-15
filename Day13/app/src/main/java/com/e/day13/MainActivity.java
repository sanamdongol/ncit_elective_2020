package com.e.day13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeActivity(View view) {
        /*Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
        startActivity(intent);*/

        startActivity(new Intent(MainActivity.this, RecyclerActivity.class));
    }
}
