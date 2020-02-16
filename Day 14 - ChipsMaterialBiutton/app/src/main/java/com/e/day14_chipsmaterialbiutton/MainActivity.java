package com.e.day14_chipsmaterialbiutton;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    TextInputLayout tvEmail;
    TextInputLayout tvPassword;
    TextInputLayout tvName;

    String[] sports = {"Ice Hockey", "Skate", "Sking", "Moto Race",
            "Skateboard", "Gymnastic", "Boxing", "Dodge Ball"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEmail = findViewById(R.id.tv_email);
        tvPassword = findViewById(R.id.tv_password);
        tvName = findViewById(R.id.tv_name);

        ChipGroup chipGroup = findViewById(R.id.chip_group);

        for (int i = 0; i < sports.length; i++) {
            Chip chip = new Chip(this);
            chip.setText(sports[i]);
            chip.setTag(sports[i]);
            chipGroup.addView(chip);

            chip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String tag = view.getTag().toString();
                    Toast.makeText(MainActivity.this, tag
                            , Toast.LENGTH_SHORT).show();
                }
            });
        }


    }

    private boolean validateEmail() {
        String email = tvEmail.getEditText().getText().toString();

        if (TextUtils.isEmpty(email)) {
            tvEmail.setError("Can't be empty");
            return true;
        } else {
            tvEmail.setError(null);
            return false;
        }
    }


    private boolean validatePassword() {
        String password = tvPassword.getEditText().getText().toString();
        if (TextUtils.isEmpty(password)) {
            tvPassword.setError("Can't be empty");
            return true;
        } else {
            tvPassword.setError(null);
            return false;
        }
    }

    private boolean validateUserName() {
        String name = tvName.getEditText().getText().toString();

        if (TextUtils.isEmpty(name)) {
            tvName.setError("Can't be empty");
            return true;
        } else if (name.length() > 15) {
            tvName.setError("Name too long.");
            return true;
        } else {
            tvName.setError(null);
            return false;
        }
    }

    public void onLogin(View view) {
       /* validateEmail();
        validatePassword();
        validateUserName();*/

        if (validateEmail() || validatePassword() || validateUserName()) {
            Toast.makeText(this, "There's error", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Form Validation Success", Toast.LENGTH_SHORT).show();
        }


    }
}
