package com.example.sqllite.ui.gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqllite.R;
import com.example.sqllite.classes.Marque;
import com.example.sqllite.service.MarqueService;

import java.util.ArrayList;

public class MArqueAdapter extends RecyclerView.Adapter<GalleryViewHolder> {
   

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.marque_item,parent,false);
        return new GalleryViewHolder(itemView) ;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
