package com.benrostudios.libground;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContributersFragment extends Fragment {

    public ContributersFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ContributersFragment newInstance(String param1, String param2) {
        ContributersFragment fragment = new ContributersFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contributers, container, false);
    }
}