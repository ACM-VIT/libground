package com.benrostudios.libground;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContributionsAdapter extends RecyclerView.Adapter<ContributionsAdapter.ViewHolder> {

    private ArrayList<Contributors> contributors;

    public ContributionsAdapter(ArrayList<Contributors> contributors) {
        this.contributors = contributors;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contributors_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.contributorsName.setText(contributors.get(position).getContributorsName());
        holder.contributorsGithubID.setText(contributors.get(position).getContributorsGithubID());
        holder.contributorsLinkedInID.setText(contributors.get(position).getContributorsLinkedInID());

    }

    @Override
    public int getItemCount() {
        return contributors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        TextView contributorsName = itemView.findViewById(R.id.contributors_name);
        TextView contributorsGithubID = itemView.findViewById(R.id.contributors_github);
        TextView contributorsLinkedInID = itemView.findViewById(R.id.contributors_linkedin);

    }

}
