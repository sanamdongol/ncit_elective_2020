package com.e.day12;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    List<PersonInfo> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linear_layout);

        String returnedResult = loadJsonFromAssets();

        try {
            JSONObject json = new JSONObject(returnedResult);
            String pageNumber = json.getString("page");
            String totalPage = json.getString("total_page");


            JSONArray jsonArray = json.getJSONArray("data");
            Log.e("json value", pageNumber + " " + totalPage);


            dataList = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Gson gson = new Gson();
                PersonInfo model = gson.fromJson(String.valueOf(jsonObject), PersonInfo.class);
                dataList.add(model);


            /*    String id = jsonObject.getString("id");
                String firstName = jsonObject.getString("first_name");
                String lastName = jsonObject.getString("sur_name");
                String email = jsonObject.getString("email");
                String image = jsonObject.getString("avatar");

                PersonInfo personInfo = new PersonInfo();
                personInfo.setId(id);
                personInfo.setFirst_name(firstName);
                personInfo.setSur_name(lastName);
                personInfo.setEmail(email);
                personInfo.setAvatar(image);
                dataList.add(personInfo);*/


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private String loadJsonFromAssets() {

        String result = null;
        try {
            InputStream inputStream = getAssets().open("my_file.json");
            int size = inputStream.available();

            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            result = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
