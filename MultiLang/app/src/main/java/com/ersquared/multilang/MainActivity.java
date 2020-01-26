package com.ersquared.multilang;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView tvHi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHi = findViewById(R.id.tvHi);
    }

    public void changeLanguage(View view) {
        String[] language = {"English", "Norwegian", "French"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose Language");
        builder.setSingleChoiceItems(language, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {
                if (position == 0) {
                    setLocal("en");
                    recreate();
                }

                if (position == 1) {
                    setLocal("no");
                    recreate();
                }

                if (position == 2) {
                    setLocal("fr");
                    recreate();
                }
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void setLocal(String selectedLanguage) {
        Locale locale = new Locale(selectedLanguage);
        Locale.setDefault(locale);

        Configuration configuration = new Configuration();
        configuration.locale = locale;

        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }


    public void showAnimation(View view) {
        Animation blinkAnim = AnimationUtils.loadAnimation
                (getApplicationContext(),
                        R.anim.blink);
        tvHi.startAnimation(blinkAnim);
    }

    private void saveDataInPreference()
    {
        /*String name = etName.getText().toString();
        String address = etAddress.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_name", name);
        editor.putString("user_address", address);
        editor.commit();*/


        //get data
       /* SharedPreferences preferences = getSharedPreferences("MyData", MODE_PRIVATE);
        String userName = preferences.getString("user_name", "no name saved");
        String userAddress = preferences.getString("user_address", "no address saved");
        Toast.makeText(this, "Name: " + userName + " " + "Address: " + userAddress, Toast.LENGTH_LONG).show();
        Log.e("Values", "Name: " + userName + " " + "Address: " + userAddress);*/
    }
}
