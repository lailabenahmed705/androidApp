package com.example.myfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    // Constantes pour les valeurs métaboliques
    private static final double MET_WALKING = 3.8; // Métabolisme pour la marche (MET)

    private EditText edt_age, edt_weight, edt_height, edt_distance;
    private Button calculateCaloriesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        calculateCaloriesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get data from edit text
                String age = edt_age.getText().toString();
                String weight = edt_weight.getText().toString();
                String height = edt_height.getText().toString();
                String distance = edt_distance.getText().toString();

                // Convertir les valeurs en int ou double selon le besoin
                int ageValue = Integer.parseInt(age);
                double weightValue = Double.parseDouble(weight);
                double heightValue = Double.parseDouble(height);
                double distanceValue = Double.parseDouble(distance);

                // Calcul des calories brûlées en fonction de l'activité (marche ou course)
                // Dans cet exemple, nous supposerons que l'utilisateur a marché
                // Déclaration et initialisation de la variable met
                final double met = MET_WALKING;
                double caloriesBurned = calculateCaloriesBurned(ageValue, weightValue, heightValue, distanceValue, met);

                // Afficher le résultat
                TextView caloriesBurnedTextView = findViewById(R.id.caloriesBurnedTextView);
                caloriesBurnedTextView.setText("Calories brûlées : " + caloriesBurned);
            }
        });
    }

    // Méthode pour calculer les calories brûlées
    private double calculateCaloriesBurned(int age, double weight, double height, double distance, double met) {
        // Calcul du taux métabolique de base (BMR) en utilisant la formule de Harris-Benedict
        double bmr;
        if (age >= 18) {
            bmr = 66.5 + (13.75 * weight) + (5.003 * height) - (6.755 * age);
        } else {
            // Utiliser une estimation pour les personnes de moins de 18 ans
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        }

        // Calcul des calories brûlées pendant l'activité physique (MET * BMR * temps)
        double caloriesBurned = met * bmr * (distance / 1000); // Conversion de la distance en kilomètres

        return caloriesBurned;
    }
}
