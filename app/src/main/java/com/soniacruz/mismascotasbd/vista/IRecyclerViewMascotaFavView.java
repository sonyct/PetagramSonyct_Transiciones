package com.soniacruz.mismascotasbd.vista;

import com.soniacruz.mismascotasbd.adapter.MascotaFavoritaAdapter;
import com.soniacruz.mismascotasbd.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewMascotaFavView {
    /*Se declara más general para que pueda ser lineal (vertical u horizontal) o grid*/
    public void generarLayout();

    public MascotaFavoritaAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicilizarAdaptadorRV(MascotaFavoritaAdapter adaptador);
}
