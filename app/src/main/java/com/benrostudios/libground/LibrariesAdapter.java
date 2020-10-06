package com.benrostudios.libground;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class LibrariesAdapter extends RecyclerView.Adapter<LibrariesAdapter.ViewHolder> {
    ArrayList<String> libraryArrayList;
    public LibrariesAdapter(ArrayList<String> libraryArrayList){
        this.libraryArrayList=libraryArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.library_card_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.libraryName.setText(libraryArrayList.get(position));
        final Context context = holder.itemView.getContext();

        holder.libraryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLibraryActivity(context,position);
        }
        });
    }

    @Override
    public int getItemCount() {
        return libraryArrayList.size();
    }

    public void goToLibraryActivity(Context context,int position){
            final Intent intent;
            switch(position){
                case 0:
                    intent=new Intent(context,GlideActivity.class);
                    break;
                default:
                    intent=new Intent(context,MainActivity.class);
            }
            context.startActivity(intent);

        }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView libraryName;
        MaterialCardView libraryCard;
        public ViewHolder(View view){
            super(view);
            libraryName=view.findViewById(R.id.library_name);
            libraryCard=view.findViewById(R.id.library_card);

        }
    }
}
