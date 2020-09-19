package com.soniacruz.mismascotasbd.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.soniacruz.mismascotasbd.R;
import com.soniacruz.mismascotasbd.db.ConstructorMascotas;
import com.soniacruz.mismascotasbd.pojo.Mascota;

import java.util.ArrayList;

public class MascotaFavoritaAdapter extends RecyclerView.Adapter<MascotaFavoritaAdapter.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaFavoritaAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    /**
     * Método que 'infla' el layout y lo pasa al viewHolder para que obtenga los views
     */
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //indicamos cual es el layout que se estará reciclando
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_fav,parent,false);
        return new MascotaViewHolder(v);
    }

    //@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    /**
     * Método que asocia cada elemento de la lista con cada view
     */
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvRate.setText(String.valueOf(mascota.getRate()));
        int numero = position + 1;
        holder.tvNumero.setText(String.valueOf(numero));

        if(Character.toUpperCase(mascota.getGenero()) == 'H' )
        {
            holder.rl_imgprofile.setBackgroundColor(this.activity.getResources().getColor(R.color.colorHembra));
        }
        else {
            holder.rl_imgprofile.setBackgroundColor(this.activity.getResources().getColor(R.color.colorMacho));
        }


        holder.btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, activity.getResources().getString(R.string.msg_clicRate)+" " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                mascota.addRate();
                holder.tvRate.setText(String.valueOf(mascota.getRate()));
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
            }
        });

    }

    @Override
    /**
     * Regresa el tamaño de la lista Mascotas
     */
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRate;
        private ImageButton btnRate;
        private ImageButton btnRating;
        private RelativeLayout rl_imgprofile;
        private TextView tvNumero;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto   = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre  = (TextView) itemView.findViewById(R.id.tvNombre);
            tvRate    = (TextView) itemView.findViewById(R.id.tvRate);
            btnRate   = (ImageButton) itemView.findViewById(R.id.btnRate);
            btnRating = (ImageButton) itemView.findViewById(R.id.btnRating);
            rl_imgprofile = (RelativeLayout) itemView.findViewById(R.id.rl_imgprofile);
            tvNumero    = (TextView) itemView.findViewById(R.id.tvNumero);
        }


    }

}

