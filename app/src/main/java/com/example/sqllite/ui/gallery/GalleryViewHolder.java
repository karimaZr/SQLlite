package com.example.sqllite.ui.gallery;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqllite.R;

class GalleryViewHolder extends RecyclerView.ViewHolder {
    TextView marquecode;
    TextView marqueName;

   public GalleryViewHolder(@NonNull View itemView){

       super(itemView);
       marquecode=itemView.findViewById(R.id.code);
       marqueName=itemView.findViewById(R.id.Name);


   }


}