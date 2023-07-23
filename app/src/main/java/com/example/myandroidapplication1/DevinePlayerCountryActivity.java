package com.example.myandroidapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DevinePlayerCountryActivity extends AppCompatActivity {


    private Logger logger = Logger.getLogger("logger");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devine_joueur);
    }

    private void initializeComponents() {
        String [] joueurs = {"neymar junior", "Kylian Mbappé", "Lionel Messi",
                "Julian Alvarez","Olivier Giroud","Marcus Rashford",
                "Bukayo Saka","Richarlison","Enner Valencia",
                "Alvaro Morata","Cody Gakpo", "Gonçalo Ramos",
                "Niclas Füllkrug","Kai Havertz","Harry Kane",
                "Salem Mohammed Al-Dawsari","Vincent Aboubakar","Gue-sung Cho",
                "Andrej Kramaric", "Ferran Torres","Mohammed Kudus",
                "Mehdi Taremi","Ritsu Doan","Youssef En-Nesyri",
                "Wout Weghorst","Robert Lewandowski","Bruno Fernandes",
                "Rafael Leão","Aleksandar Mitrovic","Breel Embolo",
                "Giorgian De Arrascaeta","Serge Gnabry","Ilkay Gündogan",
                "Jude Bellingham","Phil Foden", "Jack Grealish",
                "Jordan Henderson","Raheem Sterling","Saleh Khalid Javier Al-Shehri",
                "Angel Di Maria","Enzo Fernandez","Alexis Mac Allister",
                "Nahuel Molina", "Mitch Duke","Craig Goodwin"};
        String [] pays = {"brazil", "france", "argentine",
                "argentine", "france", "angleterre",
                "angleterre", "brazil", "equateur",
                "espagne", "pays-bas", "portugal",
                "allemagne", "allemagne", "angleterre",
                "arabie saoudite", "brazil", "cameroun",
                "corée du sud", "croatie", "espagne",
                "ghana", "iran", "japon",
                "maroc", "pays-bas", "pologne",
                "portugal", "serbie", "suisse",
                "uruguay", "allemagne", "allemagne",
                "angleterre", "angleterre", "angleterre",
                "angleterre", "angleterre", "arabie saoudite",
                "argentine", "argentine", "argentine",
                "argentine", "australie", "australie",};
        int index = getRandomNumber(0, joueurs.length-1);
        logger.log(Level.INFO,"l'index ici dans les arrays joururs et buts est {}", index);

        //Je recupere les elements web en fonction de leur ID
        TextInputEditText nationalite_joueur = (TextInputEditText) findViewById(R.id.nationalite_joueur);
        TextView joueurName = findViewById(R.id.nom_du_joueur);
        TextView verdict_nationalite_joueur = findViewById(R.id.verdict_nationalite_joueur);
        Button buttonOK = findViewById(R.id.button_nationalite);
        Button buttonBack = findViewById(R.id.button_go_back);

        //je change les textes de ces elements web à ma guise
        joueurName.setText(joueurs[index]);
        String valeurcherchee = pays[index];
        verdict_nationalite_joueur.setText("YES MANN!!");

        buttonOK.setOnClickListener(view -> {
            String nationalite = String.valueOf(nationalite_joueur.getText());
            if(valeurcherchee.equals(nationalite) || valeurcherchee.contains(nationalite) || nationalite.contains(valeurcherchee)){
                verdict_nationalite_joueur.setText("BRAVOOO!!!!!");
                buttonOK.setText("weiter");
                buttonOK.setOnClickListener(view2 -> {
                    initializeComponents();
                });
            }
            if(valeurcherchee != nationalite){
                verdict_nationalite_joueur.setText("Durchgefallen, sorry aber die antwort war falsch!");
            }
        });

        buttonBack.setOnClickListener(view -> {
            startActivity(new Intent(this.getApplicationContext(), MainActivity.class));
        });
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}