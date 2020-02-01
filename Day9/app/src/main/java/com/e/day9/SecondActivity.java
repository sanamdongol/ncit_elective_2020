package com.e.day9;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void changeFragment(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_profile:
                switchFragment(new ProfileFragment());

                break;
            case R.id.btn_home:

                HomeFragment homeFragment = new HomeFragment();
                switchFragment(homeFragment);

                break;
        }
    }

    private void switchFragment(Fragment fragment) {
        FragmentManager manager1 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction1 = manager1.beginTransaction();
        fragmentTransaction1.add(R.id.container, fragment);
        fragmentTransaction1.commit();
    }
}
