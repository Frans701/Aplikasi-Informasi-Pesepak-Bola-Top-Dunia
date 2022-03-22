package com.example.pesepakbolatopdunia;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[], data2[];
    int gambar[];
    Context context;

    public MyAdapter(Context ct, String nama_pemain[], String tim[], int img[]){
        context = ct;
        data1 = nama_pemain;
        data2 = tim;
        gambar = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.baris, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nama_pemain_bola.setText(data1[position]);
        holder.tim_pemain.setText(data2[position]);
        holder.gambar_pemain.setImageResource(gambar[position]);

        holder.mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("gambar", gambar[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambar.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nama_pemain_bola, tim_pemain;
        ImageView gambar_pemain;
        ConstraintLayout mainlayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_pemain_bola = itemView.findViewById(R.id.nama_pemain_bola);
            tim_pemain = itemView.findViewById(R.id.tim_pemain);
            gambar_pemain = itemView.findViewById(R.id.gambar_pemain);
            mainlayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
