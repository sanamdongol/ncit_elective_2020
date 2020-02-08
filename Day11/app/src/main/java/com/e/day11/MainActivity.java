package com.e.day11;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private static final String[] COUNTRIES = {"Belgium", "France", "Italy", "Germany", "Spain", "Finland"};

    private ActionMode actionMode;

    @BindView(R.id.tv_one)
    TextView tvOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        AutoCompleteTextView autoCompleteTv = findViewById(R.id.auto_complete);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, COUNTRIES);
        autoCompleteTv.setThreshold(1);
        autoCompleteTv.setAdapter(adapter);

        Button btnContextMenu = findViewById(R.id.btn_context);
        registerForContextMenu(btnContextMenu);

        btnContextMenu.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                if (actionMode != null) {
                    return false;
                }

                actionMode = startSupportActionMode(callback);
                return false;
            }
        });
    }


    @OnClick({R.id.btn_two, R.id.btn_one})
    void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                Toast.makeText(this, "Butterknife button two click", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_two:
                Toast.makeText(this, "Butterknife button one click", Toast.LENGTH_SHORT).show();
                break;
        }


    }


    private ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_main_context, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.ctx_one:
                    Toast.makeText(MainActivity.this, "Context Menu clicked", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;

        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                Toast.makeText(this, "Delete menu clicked",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_refresh:
                return true;
            case R.id.action_settings:
                return true;
            case R.id.action_one:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //PopUp menu Start ==========================
    public void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.inflate(R.menu.menu_main_pop_up);
        popup.setOnMenuItemClickListener(this);
        popup.show();

    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.item_one:
                Toast.makeText(this, "Item One  clicked",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_two:
                return true;
            case R.id.item_three:
                return true;
        }
        return false;
    }

    //popup menu end====================================

}


