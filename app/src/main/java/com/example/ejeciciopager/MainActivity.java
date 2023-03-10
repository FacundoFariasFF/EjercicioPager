package com.example.ejeciciopager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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


    String [] nombres = {"Marco","Marisol","Roberto"};
    List<String> listaNombres = Arrays.asList(nombres);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(this,listaNombres);
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