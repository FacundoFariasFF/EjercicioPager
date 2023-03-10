package com.example.ejeciciopager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

class ScreenSlidePagerAdapter extends FragmentStateAdapter{
    static List<String> listaNombresAux;
    public ScreenSlidePagerAdapter(FragmentActivity fa, List<String> listaNombres) {
        super(fa);
        listaNombresAux = listaNombres;
    }

    @Override
    public Fragment createFragment(int position) {

        return FragmentA.newInstance(listaNombresAux.get(position));
    }

    @Override
    public int getItemCount() {

        return listaNombresAux.size();
    }
}