package com.example.samochody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_cars);
        new FirebaseDatabaseHelper().readCars(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<car> cars, List<String> keys) {
               findViewById(R.id.loading_cars_pb).setVisibility(View.GONE);
                new RecyclerView_Config().setConfig(mRecyclerView, MainActivity.this, cars, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.carlist_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_car:
            startActivity(new Intent(this, NewCarActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}