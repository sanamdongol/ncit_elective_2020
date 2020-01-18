package com.ersquared.dialogfonts;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Button loginBtn = findViewById(R.id.btn_login);
        address = findViewById(R.id.etAddress);
        name = findViewById(R.id.etName);
      
      
        View layout = findViewById(R.id.newLayout);
        Button btnTest = layout.findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "ssssss", Toast.LENGTH_SHORT).show();
            }
        });


        // Typeface typeface = getResources().getFont(R.font.font_name);
        // textView.setTypeface(typeface);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Typeface typeFace = getResources().getFont(R.font.sacramento_regular);
            address.setTypeface(typeFace);
        }


    }

    public void letsClick(View view) {
        String userName = name.getText().toString();
        String userAddress = address.getText().toString();

        Log.e("User Name Check", userName);
        Log.e("User Address Check", userAddress);

        boolean hasError = false;
        if (TextUtils.isEmpty(userName)) {
            name.setError("Name field is required");
            hasError = true;
        }


        if (TextUtils.isEmpty(userAddress)) {
            address.setError("Address field is required");
            hasError = true;
        }

        if (hasError == false) {

        }
    }
}
