package com.e.day9;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    ConstraintLayout constraintLayout;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.rootLayout);
        Log.i(TAG, "onCreate: ");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

    public void showSnackBar(View view) {

        int id = view.getId();
        switch (id) {
            case R.id.btn_show_snack:
                Snackbar.make(
                        constraintLayout,
                        "This is snackbar",
                        Snackbar.LENGTH_LONG
                ).show();

                break;
            case R.id.btn_snack_action:
                Snackbar.make(constraintLayout,
                        "Item Removed",
                        Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar.make(
                                        constraintLayout,
                                        "Item Restored Successfully",
                                        Snackbar.LENGTH_LONG
                                ).show();
                            }
                        }).show();

                break;

        }

        /*
        if (id == R.id.btn_show_snack) {

        } else if (id == R.id.btn_snack_action) {

        }*/


    }

    public void changeActivity(View view) {
        Intent intent = new Intent(
                MainActivity.this,
                SecondActivity.class);
        startActivity(intent);
    }
}
