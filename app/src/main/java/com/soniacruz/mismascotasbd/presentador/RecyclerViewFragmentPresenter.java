package com.soniacruz.mismascotasbd.presentador;

import android.content.Context;

import com.soniacruz.mismascotasbd.db.ConstructorMascotas;
import com.soniacruz.mismascotasbd.pojo.Mascota;
import com.soniacruz.mismascotasbd.vista.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter (IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerItems();
    }

    @Override
    public void obtenerItems() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatosIniciales(); //datos de un ArrayList
        mostrarItemsRV();
    }

    @Override
    public void mostrarItemsRV() {
        iRecyclerViewFragmentView.inicilizarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador((mascotas)));
        iRecyclerViewFragmentView.generarLayout();
    }
}
