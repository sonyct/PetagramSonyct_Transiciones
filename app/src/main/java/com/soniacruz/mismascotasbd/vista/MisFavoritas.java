package com.soniacruz.mismascotasbd.vista;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;

import com.soniacruz.mismascotasbd.R;
import com.soniacruz.mismascotasbd.adapter.MascotaFavoritaAdapter;
import com.soniacruz.mismascotasbd.pojo.Mascota;
import com.soniacruz.mismascotasbd.presentador.IRecyclerViewFragmentPresenter;
import com.soniacruz.mismascotasbd.presentador.RecyclerViewMisFavoritasPresenter;

import java.util.ArrayList;

public class MisFavoritas extends AppCompatActivity implements IRecyclerViewMascotaFavView {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionBarFav);
        setSupportActionBar(miActionBar);


        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Habilita el botón Subir
        ab.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setIcon(R.drawable.ic_footprint);

        rvMascotas = (RecyclerView) findViewById(R.id.rvFavoritas);
        presenter = new RecyclerViewMisFavoritasPresenter(this,this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Fade fade = new Fade();
            fade.setDuration(1200);
            fade.setMode(Fade.MODE_IN);
            getWindow().setEnterTransition(fade);
            getWindow().setReturnTransition(new Fade(Fade.OUT));
        }

    }


    @Override
    public void generarLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaFavoritaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaFavoritaAdapter adaptador = new MascotaFavoritaAdapter(mascotas,this);
        return adaptador;
    }

    @Override
    public void inicilizarAdaptadorRV(MascotaFavoritaAdapter adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}