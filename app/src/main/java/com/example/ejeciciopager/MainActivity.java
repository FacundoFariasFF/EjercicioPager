package com.example.ejeciciopager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends FragmentActivity {



    private ViewPager2 viewPager;

    private FragmentStateAdapter pagerAdapter;


    //String [] nombres = {"Roberto","Facundo"};
   // List<String> listaNombres = Arrays.asList(nombres);
    List<String> listapilotos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listapilotos.add("rossi");
        listapilotos.add("marquez");
        listapilotos.add("lorenzo");
        viewPager = findViewById(R.id.pager);


        //aca va el codigo para capturar la posicion del pager
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);}
            @Override
            public void onPageSelected(int position){
                super.onPageSelected(position);
                Toast.makeText(MainActivity.this,"fragment nro: "+position,Toast.LENGTH_SHORT).show();

                if (position==listapilotos.size()-1){
                    //listaNombres.add(4,"Messi");
                    listapilotos.add("messi");
                    pagerAdapter.notifyDataSetChanged();
                }

            }
           @Override
            public void onPageScrollStateChanged(int state){
                super.onPageScrollStateChanged(state);
            }
        });

        pagerAdapter = new ScreenSlidePagerAdapter(this,listapilotos);
        viewPager.setAdapter(pagerAdapter);

        //FragmentA.newInstance(listaNombres);

    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {

            super.onBackPressed();
        } else {

            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

}