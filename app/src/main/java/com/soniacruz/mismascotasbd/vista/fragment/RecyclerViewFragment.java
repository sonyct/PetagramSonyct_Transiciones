package com.soniacruz.mismascotasbd.vista.fragment;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionInflater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soniacruz.mismascotasbd.R;
import com.soniacruz.mismascotasbd.adapter.MascotaAdapter;
import com.soniacruz.mismascotasbd.pojo.Mascota;
import com.soniacruz.mismascotasbd.presentador.IRecyclerViewFragmentPresenter;
import com.soniacruz.mismascotasbd.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this vista.fragment
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this,getContext());

        //TransitionInflater transitionInflater = TransitionInflater.from(requireContext());
        //setExitTransition(transitionInflater.inflateTransition(R.transition.fade));
        return v;
    }


    @Override
    public void generarLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdapter adaptador = new MascotaAdapter(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicilizarAdaptadorRV(MascotaAdapter adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}