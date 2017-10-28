package com.example.alex.bitsandpizzas;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PizzaMaterialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pizzasRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_pizza_material, container, false);
        String[] pizzasNames = new String[Pizza.pizzas.length];
        for (int i = 0; i < pizzasNames.length; i++){
            pizzasNames[i] = Pizza.pizzas[i].getName();
        }

        int[] pizzasImages = new int[Pizza.pizzas.length];
        for (int i = 0; i < pizzasImages.length; i++){
            pizzasImages[i] = Pizza.pizzas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzasNames, pizzasImages);
        pizzasRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        pizzasRecycler.setLayoutManager(layoutManager);
        return pizzasRecycler;
    }

}
