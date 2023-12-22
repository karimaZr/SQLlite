package com.example.sqllite;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqllite.service.EtudiantService;
import com.example.sqllite.classes.Etudiant;


public class MainActivity extends AppCompatActivity {

    private EditText nom;
    private EditText prenom;
    private Button add;


    private EditText id;
    private Button rechercher;
    private TextView res;

    //Méthode pour vider les champs après l’ajout
    void clear(){
        nom.setText("");
        prenom.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        EtudiantService es = new EtudiantService(this);

        //Insertion des étudiants
        es.create(new Etudiant("ALAMI", "ALI"));
        es.create(new Etudiant("RAMI", "AMAL"));
        es.create(new Etudiant("SAFI", "MHMED"));
        es.create(new Etudiant("SELAOUI", "REDA"));
        es.create(new Etudiant("ALAMI", "WAFA"));

        //Parcourir la liste des étudiants
        for(Etudiant e : es.findAll()){
            Log.d(e.getId()+"", e.getNom()+" "+e.getPrenom());
        }

//Supprimer l'élement dont id = 3
        es.delete(es.findById(3));

        //Liste après suppression
        Log.d("delete","Après suppression");
        for(Etudiant e : es.findAll()){
            Log.d(e.getId()+"", e.getNom()+" "+e.getPrenom());
        }
*/

        final EtudiantService es = new EtudiantService(this);

        nom = (EditText)findViewById(R.id.nom);
        prenom = (EditText)findViewById(R.id.prenom);
        add = (Button)findViewById(R.id.bn);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Insertion des étudiants
                es.create(new Etudiant(nom.getText().toString(), prenom.getText().toString()));
                clear();
                //Parcourir la liste des étudiants
                for(Etudiant e : es.findAll()){
                    Log.d(e.getId()+"", e.getNom()+" "+e.getPrenom());
                }
            }
        });

        id = (EditText)findViewById(R.id.id);
        rechercher = (Button)findViewById(R.id.load);
        res = (TextView)findViewById(R.id.res);

        rechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Etudiant e = es.findById(Integer.parseInt(id.getText().toString()));
                res.setText(e.getNom()+" "+e.getPrenom());
            }
        });
        Button delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Etudiant etudiant =es.findById(Integer.parseInt(id.getText().toString()));
                es.delete(etudiant);
                Toast.makeText(getApplicationContext(),"etudiant supprimer avec succée",Toast.LENGTH_LONG).show();

            }
        });


    }
}
