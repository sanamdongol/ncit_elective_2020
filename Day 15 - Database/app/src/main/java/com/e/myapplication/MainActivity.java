package com.e.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etId;
    private EditText etName;
    private EditText etAddress;
    private MyAppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                MyAppDatabase.class,
                "CustomerDB").
                allowMainThreadQueries().build();

        etId = findViewById(R.id.et_id);
        etName = findViewById(R.id.et_name);
        etAddress = findViewById(R.id.et_address);
    }

    public void onButtonClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btn_save:
                saveData();
                break;

            case R.id.btn_show:
                showData();
                break;

            case R.id.btn_update:
                updateCustomerDetail();
                break;
            case R.id.btn_delete:
                deleteCustomer();
                break;
        }
    }

    private void deleteCustomer() {
        int customerId = Integer.parseInt(etId.getText().toString());
        Customer customer = new Customer();
        customer.setId(customerId);
        appDatabase.customerDao().deleteCustomer(customer);
        hideKeyboard();
    }

    private void updateCustomerDetail() {
        String id = etId.getText().toString();
        String name = etName.getText().toString();
        String address = etAddress.getText().toString();

        Customer customer = new Customer();
        customer.setId(Integer.parseInt(id));
        customer.setName(name);
        customer.setAddress(address);
        appDatabase.customerDao().updateCustomer(customer);
        Toast.makeText(this, "Update Success", Toast.LENGTH_SHORT).show();
        hideKeyboard();
    }

    private void showData() {
        List<Customer> customerList = appDatabase.customerDao().getAllCustomer();
        for (Customer customer : customerList) {
            String customerId = String.valueOf(customer.getId());
            String name = customer.getName();
            String address = customer.getAddress();
            Log.e("Data", customerId + " " + name + " " + address);
        }
        hideKeyboard();

    }

    private void saveData() {
        String id = etId.getText().toString();
        String name = etName.getText().toString();
        String address = etAddress.getText().toString();

        Customer customer = new Customer();
        customer.setId(Integer.parseInt(id));
        customer.setName(name);
        customer.setAddress(address);

        appDatabase.customerDao().addCustomer(customer);
        Toast.makeText(this, "Customer added successfully", Toast.LENGTH_SHORT).show();
        hideKeyboard();
    }

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(this);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
