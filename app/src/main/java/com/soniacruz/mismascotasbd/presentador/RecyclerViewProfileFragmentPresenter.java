package com.soniacruz.mismascotasbd.presentador;

import android.content.Context;

import com.soniacruz.mismascotasbd.db.ConstructorFotos;
import com.soniacruz.mismascotasbd.pojo.Foto;
import com.soniacruz.mismascotasbd.vista.fragment.IRecyclerViewProfileFragmentView;

import java.util.ArrayList;

public class RecyclerViewProfileFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewProfileFragmentView iRecyclerViewProfileFragmentView;
    private Context context;
    private ConstructorFotos constructorFotos;
    private ArrayList<Foto> fotos;

    public RecyclerViewProfileFragmentPresenter (IRecyclerViewProfileFragmentView iRecyclerViewProfileFragmentView, Context context){
        this.iRecyclerViewProfileFragmentView = iRecyclerViewProfileFragmentView;
        this.context = context;
        obtenerItems();
    }

    @Override
    public void obtenerItems() {
        constructorFotos = new ConstructorFotos(context);
        fotos = constructorFotos.obtenerDatosIniciales();
        mostrarItemsRV();
    }

    @Override
    public void mostrarItemsRV() {
        iRecyclerViewProfileFragmentView.inicilizarAdaptadorRV(iRecyclerViewProfileFragmentView.crearAdaptador(fotos));
        iRecyclerViewProfileFragmentView.generarLayout();
    }
}
