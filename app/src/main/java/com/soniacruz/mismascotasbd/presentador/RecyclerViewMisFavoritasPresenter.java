package com.soniacruz.mismascotasbd.presentador;

import android.content.Context;

import com.soniacruz.mismascotasbd.db.ConstructorMascotas;
import com.soniacruz.mismascotasbd.pojo.Mascota;
import com.soniacruz.mismascotasbd.vista.IRecyclerViewMascotaFavView;

import java.util.ArrayList;

public class RecyclerViewMisFavoritasPresenter  implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewMascotaFavView iRecyclerViewMascotaFavView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewMisFavoritasPresenter (IRecyclerViewMascotaFavView iRecyclerViewMascotaFavView, Context context){
        this.iRecyclerViewMascotaFavView = iRecyclerViewMascotaFavView;
        this.context = context;
        obtenerItems();
    }

    @Override
    public void obtenerItems() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotasFavoritas(); //datos de la base de datos
        //mascotas = constructorMascotas.obtenerMascotasFavoritasDummy(); //datos de un ArrayList
        mostrarItemsRV();
    }

    @Override
    public void mostrarItemsRV() {
        iRecyclerViewMascotaFavView.inicilizarAdaptadorRV(iRecyclerViewMascotaFavView.crearAdaptador((mascotas)));
        iRecyclerViewMascotaFavView.generarLayout();
    }
}
