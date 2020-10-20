package com.acmvit.libground;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ContributorsFragment extends Fragment {

    ArrayList<Contributors> contributors = new ArrayList<>();
    RecyclerView contributorsRecyclerView;

    public ContributorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contributors, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setContributors();
        contributorsRecyclerView = view.findViewById(R.id.contributors_rv);
        LinearLayoutManager contributionsLinearLayoutManager = new LinearLayoutManager(getContext());
        contributionsLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        contributorsRecyclerView.setLayoutManager(contributionsLinearLayoutManager);
        contributorsRecyclerView.setAdapter(new ContributionsAdapter(contributors));
        ViewCompat.setNestedScrollingEnabled(contributorsRecyclerView, false);
    }

    public void setContributors() {
        contributors.add(new Contributors("Brabant Nicolas", "nbrabant", "nicolas-brabant-9210b531"));
        contributors.add(new Contributors("Nowele Rechka", "https://github.com/Nowele", "https://www.linkedin.com/in/nowele/"));
        contributors.add(new Contributors("Nabilla Sabbaha", "nabillasab", "nabillasabbaha"));
        contributors.add(new Contributors("Alvin Tandiardi", "alvintan05", "alvin-tandiardi"));
        contributors.add(new Contributors("Contributor Name", "Github ID", "LinkedIn ID"));
    }
}
