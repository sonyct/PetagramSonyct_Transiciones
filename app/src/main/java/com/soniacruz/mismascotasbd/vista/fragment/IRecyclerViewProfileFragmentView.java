package com.soniacruz.mismascotasbd.vista.fragment;

import com.soniacruz.mismascotasbd.adapter.FotoAdapter;
import com.soniacruz.mismascotasbd.pojo.Foto;

import java.util.ArrayList;

public interface IRecyclerViewProfileFragmentView {
    /*Se declara más general para que pueda ser lineal (vertical u horizontal) o grid*/
    public void generarLayout();

    public FotoAdapter crearAdaptador(ArrayList<Foto> fotos);

    public void inicilizarAdaptadorRV(FotoAdapter adaptador);
}
