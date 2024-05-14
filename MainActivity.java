package com.example.myfitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateCaloriesBtn  = findViewById(R.id.calculateCaloriesBtn);
        calculateCaloriesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ageEditText = findViewById(R.id.edt_age);
                EditText weightEditText = findViewById(R.id.edt_weight);
                EditText heightEditText = findViewById(R.id.edt_height);
                EditText distanceEditText = findViewById(R.id.edt_distance);
                int age = Integer.parseInt(ageEditText.getText().toString());
                double weight = Double.parseDouble(weightEditText.getText().toString());
                double height = Double.parseDouble(heightEditText.getText().toString());
                double distance = Double.parseDouble(distanceEditText.getText().toString());

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("age", age);
                intent.putExtra("weight", weight);
                intent.putExtra("height", height);
                intent.putExtra("height", distance);
                startActivity(intent);
            }
        });
    }
}
