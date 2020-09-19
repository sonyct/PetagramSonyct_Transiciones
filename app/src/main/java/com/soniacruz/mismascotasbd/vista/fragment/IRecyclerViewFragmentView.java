package com.soniacruz.mismascotasbd.vista.fragment;

import com.soniacruz.mismascotasbd.adapter.MascotaAdapter;
import com.soniacruz.mismascotasbd.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    /*Se declara más general para que pueda ser lineal (vertical u horizontal) o grid*/
    public void generarLayout();

    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicilizarAdaptadorRV(MascotaAdapter adaptador);
}
