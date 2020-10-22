package com.acmvit.libground;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.acmvit.libground.Constants.EXO_PLAYER;
import static com.acmvit.libground.Constants.FAN;
import static com.acmvit.libground.Constants.LOTTIE;
import static com.acmvit.libground.Constants.RETROFIT;
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
        arrayList.clear();
        arrayList.add(getString(R.string.glide));
        arrayList.add(SHIMMER);
        arrayList.add(LOTTIE);
        arrayList.add(RETROFIT);
        arrayList.add(FAN);
        arrayList.add(EXO_PLAYER);
    }
}