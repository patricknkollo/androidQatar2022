package com.example.myandroidapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myandroidapplication1.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private Logger logger = Logger.getLogger("logger");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    /*    BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);*/

     initializeComponents();

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
        int [] buts = {2, 8, 7,
                4, 4, 3,
                3, 3, 3,
                3, 3, 3,
                2, 2, 2,
                2, 2, 2,
                2, 2, 2,
                2, 2, 2,
                2, 2, 2,
                2, 2, 2,
                2, 1, 1,
                1, 1, 1,
                1, 1, 1,
                1, 1, 1,
                1, 1, 1};
        int index = getRandomNumber(0, joueurs.length-1);
        logger.log(Level.INFO,"l'index ici dans les arrays joururs et buts est {}", index);

        //Je recupere les elements web en fonction de leur ID
        TextInputEditText buts_entrees = (TextInputEditText) findViewById(R.id.buts_entres);
        TextView joueurName = findViewById(R.id.joueur_name);
        TextView dichotomie = findViewById(R.id.indication_dichotomique);
        Button buttonOK = findViewById(R.id.bouton_OK);
        Button buttonFoward = findViewById(R.id.button_go_forward);

        //je change les textes de ces elements web à ma guise
        joueurName.setText(joueurs[index]);
        int valeurcherchee = buts[index];
        dichotomie.setText("YES MANN!!");

        buttonOK.setOnClickListener(view -> {
            String buts_entrees_string = String.valueOf(buts_entrees.getText());
           // String branch = String.valueOf(joueurName.getText());
            int reel = Integer.parseInt(buts_entrees_string);
               if(valeurcherchee == reel){
                   dichotomie.setText("BRAVOOO!!!!!");
                   //buttonOK.setText("weiter");
                   buttonOK.setOnClickListener(view2 -> {
                      initializeComponents();
                      buts_entrees.setText("");
                   });
               }
               if(valeurcherchee > reel){
                   dichotomie.setText("plus grand");
               }
               if(valeurcherchee < reel){
                   dichotomie.setText("plus petit");
               }
        });
        buttonFoward.setOnClickListener(view -> {
            startActivity(new Intent(this.getApplicationContext(), DevinePlayerCountryActivity.class));
        });
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}