package com.ersquared.shapeslayoutinflation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] fruits = {"Apple", "Mango", "orange", "papayae", "pear", "lisdfhlsd", "lkdsfls"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = findViewById(R.id.linearLayout);

        for (int i = 0; i < fruits.length; i++) {
            View myLayout = LayoutInflater.from(this).inflate(R.layout.row_list, null);
            TextView name = myLayout.findViewById(R.id.tv_name);
            name.setText(fruits[i]);
            layout.addView(myLayout);
        }


    }

    public void showDialog(View view) {
        showCustomDialog();
    }

    private void showCustomDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.row_list, null);


        builder.setView(view);
        builder.create();

        builder.show();


    }

    private void showDefaultDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Exit?");
        builder.setMessage("Do you really want to exit from this app?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Positive button pressed", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Negative button pressed", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });

        builder.show();

    }
}
