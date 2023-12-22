package com.example.sqllite.ui.gallery;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqllite.R;
import com.example.sqllite.classes.Marque;
import com.example.sqllite.databinding.FragmentGalleryBinding;
import com.example.sqllite.service.MarqueService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class GalleryFragment extends Fragment {

    private FloatingActionButton add;
    RecyclerView recyclerView;
    MArqueAdapter mArqueAdapter;
    RecyclerView.LayoutManager layoutManager;




    public GalleryFragment() {
        // Required empty public constructor
    }

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel homeViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final MarqueService es = new MarqueService(requireContext());


        add = root.findViewById(R.id.addbutton);
        add.setOnClickListener(v -> showDialog());
        /*add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                es.create(new Marque(code.getText().toString(), marque.getText().toString()));
                clear();
                Toast.makeText(requireContext(), "Marque ajouté avec succès", Toast.LENGTH_SHORT).show();
            }
        });*/

        /*id = root.findViewById(R.id.id);
        rechercher = root.findViewById(R.id.load);
        res = root.findViewById(R.id.res);

        rechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Marque e = es.findById(Integer.parseInt(id.getText().toString()));
                if (e != null) {
                    res.setText(e.getCode() + " " + e.getMarque());
                } else {
                    res.setText("Marque non trouvé");
                }
            }
        });

        Button delete = root.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Marque marque1 = es.findById(Integer.parseInt(id.getText().toString()));
                if (marque1 != null) {
                    es.delete(marque1);
                    Toast.makeText(requireContext(), "Marque  supprimé avec succès", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(requireContext(), "Marque non trouvé", Toast.LENGTH_SHORT).show();
                }
            }
        });*/

        return root;
    }

    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        View view = LayoutInflater.from(this.getContext()).inflate(R.layout.class_dialog, null);
        builder.setView(view);
        builder.create().show();
    }

     /*private void clear() {
        code.setText("");
        marque.setText("");
    }*/

}
