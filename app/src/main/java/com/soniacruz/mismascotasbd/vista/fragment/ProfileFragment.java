package com.soniacruz.mismascotasbd.vista.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionInflater;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soniacruz.mismascotasbd.R;
import com.soniacruz.mismascotasbd.adapter.FotoAdapter;
import com.soniacruz.mismascotasbd.pojo.Foto;
import com.soniacruz.mismascotasbd.presentador.IRecyclerViewFragmentPresenter;
import com.soniacruz.mismascotasbd.presentador.RecyclerViewProfileFragmentPresenter;

import java.util.ArrayList;


public class ProfileFragment extends Fragment implements IRecyclerViewProfileFragmentView {

    private ArrayList<Foto> fotos;
    private RecyclerView rvFotos;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this vista.fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

/*
        TransitionInflater inflaterTransition = TransitionInflater.from(requireContext());
        setEnterTransition(inflaterTransition.inflateTransition(R.transition.slide_right));*/

        rvFotos = (RecyclerView) v.findViewById(R.id.rvImgProfile);
        presenter = new RecyclerViewProfileFragmentPresenter(this,getContext());
        return v;
    }

    @Override
    public void generarLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        rvFotos.setLayoutManager(glm);
    }

    @Override
    public FotoAdapter crearAdaptador(ArrayList<Foto> fotos) {
        FotoAdapter adaptador = new FotoAdapter(fotos, getActivity());
        return adaptador;
    }

    @Override
    public void inicilizarAdaptadorRV(FotoAdapter adaptador) {
        rvFotos.setAdapter(adaptador);
    }


}