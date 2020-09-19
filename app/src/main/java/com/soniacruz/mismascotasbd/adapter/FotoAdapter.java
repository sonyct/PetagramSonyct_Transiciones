package com.soniacruz.mismascotasbd.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.soniacruz.mismascotasbd.R;
import com.soniacruz.mismascotasbd.pojo.Foto;

import java.util.ArrayList;

public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.FotoViewHolder>{

    ArrayList<Foto> fotos;
    Activity activity;

    public FotoAdapter(ArrayList<Foto> fotos, Activity activity) {
        this.fotos = fotos;
        this.activity = activity;
    }

    @NonNull
    @Override
    public FotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_improfile,parent,false);
        return new FotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FotoViewHolder holder, int position) {
        final Foto foto = fotos.get(position);
        holder.imgFoto.setImageResource(foto.getFoto());
        holder.tvRate.setText(String.valueOf(foto.getRate()));
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class FotoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvRate;

        public FotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto   = (ImageView) itemView.findViewById(R.id.imgPhotoProfile);
            tvRate    = (TextView) itemView.findViewById(R.id.tvRateImg);
        }
    }
}
