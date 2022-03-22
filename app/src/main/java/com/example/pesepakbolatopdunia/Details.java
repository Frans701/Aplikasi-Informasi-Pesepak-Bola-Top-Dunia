package com.example.pesepakbolatopdunia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends AppCompatActivity {

    ImageView gambar_pemain_details;
    TextView nama_pemain_details, tim_pemain_details;

    String data1, data2;
    int gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        gambar_pemain_details = findViewById(R.id.gambar_pemain_details);
        nama_pemain_details = findViewById(R.id.nama_pemain_details);
        tim_pemain_details = findViewById(R.id.tim_pemain_details);

        getData();
        setData();
    }

    private void getData(){
        if (getIntent().hasExtra("data1") && getIntent().hasExtra("data2") &&
        getIntent().hasExtra("gambar")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            gambar = getIntent().getIntExtra("gambar", 1);
        } else{
            Toast.makeText(this, "No data" ,Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        nama_pemain_details.setText(data1);
        tim_pemain_details.setText(data2);
        gambar_pemain_details.setImageResource(gambar);
    }
}

