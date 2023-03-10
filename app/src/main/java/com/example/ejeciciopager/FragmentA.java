package com.example.ejeciciopager;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentA extends Fragment {

    View rootView;
    private TextView text;

    private String nroFragment;


    public FragmentA() {
        // Required empty public constructor
    }

    @NonNull
    public static FragmentA newInstance(String nroFragment) {
        FragmentA fragment = new FragmentA();
        Bundle args = new Bundle();
        args.putString("nombreFragment", nroFragment);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nroFragment = getArguments().getString("nombreFragment");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_a, container, false);

        text = rootView.findViewById(R.id.text);

        text.setText("fragment "+ nroFragment );


        return rootView;
    }
}