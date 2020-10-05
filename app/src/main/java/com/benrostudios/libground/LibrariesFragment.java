package com.benrostudios.libground;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class LibrariesFragment extends Fragment {

    public LibrariesFragment() {
        // Required empty public constructor
    }


    public static LibrariesFragment newInstance(String param1, String param2) {
        LibrariesFragment fragment = new LibrariesFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_libraries, container, false);
    }
}