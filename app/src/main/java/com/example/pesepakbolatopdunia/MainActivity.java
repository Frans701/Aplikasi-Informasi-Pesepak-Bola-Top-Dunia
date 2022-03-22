package com.example.pesepakbolatopdunia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String nama_pemain[], tim[];
    int gambar[] = {R.drawable.messi, R.drawable.ronaldo, R.drawable.neymar,
            R.drawable.mbappe, R.drawable.lewandowski, R.drawable.suarez, R.drawable.salah,
            R.drawable.kane, R.drawable.benzema};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        nama_pemain = getResources().getStringArray(R.array.nama_pemain);
        tim = getResources().getStringArray(R.array.tim);

        MyAdapter myAdapter = new MyAdapter(this, nama_pemain, tim, gambar);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}