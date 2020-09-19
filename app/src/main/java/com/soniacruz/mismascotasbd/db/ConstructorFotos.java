package com.soniacruz.mismascotasbd.db;

import android.content.Context;

import com.soniacruz.mismascotasbd.R;
import com.soniacruz.mismascotasbd.pojo.Foto;

import java.util.ArrayList;

public class ConstructorFotos {

    private Context context;

    public ConstructorFotos (Context context){
        this.context=context;
    }

    public ArrayList<Foto> obtenerDatosIniciales(){
        ArrayList<Foto> fotos = new ArrayList<Foto>();

        fotos.add(new Foto(R.drawable.dalmata,3));
        fotos.add(new Foto(R.drawable.dalmata_01,5));
        fotos.add(new Foto(R.drawable.dalmata_02,8));
        fotos.add(new Foto(R.drawable.dalmata_03,2));
        fotos.add(new Foto(R.drawable.dalmata_04,1));
        fotos.add(new Foto(R.drawable.dalmata_06,9));
        fotos.add(new Foto(R.drawable.dalmata_07,4));
        fotos.add(new Foto(R.drawable.dalmata_08,9));
        fotos.add(new Foto(R.drawable.dalmata_09,6));

        return fotos;
    }
}
