package com.acmvit.libground;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.acmvit.libground.retrofit.RetrofitActivity;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

import static com.acmvit.libground.Constants.BIOMETRIC;
import static com.acmvit.libground.Constants.EXO_PLAYER;
import static com.acmvit.libground.Constants.FAN;
import static com.acmvit.libground.Constants.LOTTIE;
import static com.acmvit.libground.Constants.RETROFIT;
import static com.acmvit.libground.Constants.SHIMMER;

public class LibrariesAdapter extends RecyclerView.Adapter<LibrariesAdapter.ViewHolder> {
    ArrayList<String> libraryArrayList;

    public LibrariesAdapter(ArrayList<String> libraryArrayList) {
        this.libraryArrayList = libraryArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.library_card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.libraryName.setText(libraryArrayList.get(position));
        final Context context = holder.itemView.getContext();

        holder.libraryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLibraryActivity(context, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return libraryArrayList.size();
    }

    public void goToLibraryActivity(Context context, int position) {
        final Intent intent;
        switch (libraryArrayList.get(position)) {
            case "Glide":
                intent = new Intent(context, GlideActivity.class);
                break;
            case SHIMMER:
                intent = new Intent(context, ShimmerActivity.class);
                break;
            case LOTTIE:
                intent = new Intent(context, LottieActivity.class);
                break;
            case RETROFIT:
                intent = new Intent(context, RetrofitActivity.class);
                break;
            case FAN:
                intent = new Intent(context, FastAndroidNetworkingActivity.class);
                break;
            case EXO_PLAYER:
                intent = new Intent(context, ExoPlayerActivity.class);
                break;
            case BIOMETRIC:
                intent = new Intent(context, BiometricActivity.class);
                break;
            default:
                intent = new Intent(context, MainActivity.class);
        }
        context.startActivity(intent);

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView libraryName;
        MaterialCardView libraryCard;

        public ViewHolder(View view) {
            super(view);
            libraryName = view.findViewById(R.id.library_name);
            libraryCard = view.findViewById(R.id.library_card);

        }
    }
}
