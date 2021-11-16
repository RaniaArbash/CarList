package com.example.carlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CarAdapter.calListClickListener{

    RecyclerView car_tabel;
    ArrayList carList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        car_tabel = findViewById(R.id.list_car);
        car_tabel.setLayoutManager(new LinearLayoutManager(this));
        carList = new ArrayList(0);
        carList.add(new Car("Nissan",R.drawable.car1));
        carList.add(new Car("Mazda",R.drawable.car2));
        carList.add(new Car("BMW",R.drawable.car3));
        carList.add(new Car("Ford",R.drawable.car2));
        carList.add(new Car("Honda",R.drawable.car1));
        carList.add(new Car("Toyota",R.drawable.car3));
        carList.add(new Car("Hundai",R.drawable.car1));

        CarAdapter adapter = new CarAdapter(this,carList);
        adapter.listener = this;
        car_tabel.setAdapter(adapter);
    }

    @Override
    public void onCarSelected(Car selectedCar) {
        Toast.makeText(this,selectedCar.car_model + " is Selected",Toast.LENGTH_LONG ).show();
    }
}
