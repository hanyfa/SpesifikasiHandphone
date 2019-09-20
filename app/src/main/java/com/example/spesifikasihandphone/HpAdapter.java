package com.example.spesifikasihandphone;

import android.app.Activity;
import android.content.Intent;
import android.telecom.Call;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class HpAdapter extends RecyclerView.Adapter<HpAdapter.hpHolder> {
    List<Handphone> handphones;
    Activity activity;


    public HpAdapter(List<Handphone> handphones, Activity activity) {
        this.handphones = handphones;
        this.activity = activity;
    }

    @NonNull
    @Override
    public hpHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.hp_item,parent,false);

        return new hpHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull hpHolder holder, final int position) {
        holder.txtNamaProduk.setText(handphones.get(position).getNama_produk());
        Picasso.with(activity).load(handphones.get(position).getPic()).into(holder.imghp);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handphone hp=handphones.get(position);
                Intent PINDAH=new Intent(activity,Detail_Activity.class);
                PINDAH.putExtra(Detail_Activity.KEY_ACTIVITY,hp);
                view.getContext().startActivity(PINDAH);
            }
        });

    }

    @Override
    public int getItemCount() {
        return handphones.size();
    }

    static class hpHolder extends RecyclerView.ViewHolder{
        TextView txtNamaProduk;
        TextView txtRam;
        TextView txtInternalMemory;
        ImageView imghp;
        TextView txtHarga;

        public hpHolder(@NonNull View itemView){
            super(itemView);
            txtNamaProduk=(TextView)itemView.findViewById(R.id.txt_nama_produk);
            txtRam=(TextView)itemView.findViewById(R.id.txt_ram);
            txtInternalMemory=(TextView)itemView.findViewById(R.id.txt_internal_memory);
            txtHarga=(TextView)itemView.findViewById(R.id.txt_harga);
            imghp=(ImageView) itemView.findViewById(R.id.img_hp);

        }
    }
}
