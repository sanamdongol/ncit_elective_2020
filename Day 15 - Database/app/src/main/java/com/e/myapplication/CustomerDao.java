package com.e.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CustomerDao {

    @Insert
    public void addCustomer(Customer customer);

    @Query("Select * from Customer")
    public List<Customer> getAllCustomer();

    @Update
    public void updateCustomer(Customer customer);

    @Delete
    public void deleteCustomer(Customer customer);
}
