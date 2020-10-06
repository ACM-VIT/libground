package com.acmvit.libground;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

import static com.acmvit.libground.Constants.GLIDE;
import static com.acmvit.libground.Constants.SHIMMER;


public class LibrariesFragment extends Fragment {
    ArrayList<String> arrayList = new ArrayList<>();

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
        setLibraries();
        View root = inflater.inflate(R.layout.fragment_libraries, container, false);
        RecyclerView libraryRecyclerView = root.findViewById(R.id.library_list);
        LibrariesAdapter librariesAdapter = new LibrariesAdapter(arrayList);
        libraryRecyclerView.setAdapter(librariesAdapter);
        return root;
    }

    public void setLibraries() {
        arrayList.add(GLIDE);
        arrayList.add(SHIMMER);
    }
}