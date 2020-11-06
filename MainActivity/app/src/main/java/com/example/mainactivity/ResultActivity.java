package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String age = i.getStringExtra("age");
        String str1 = i.getStringExtra("weight");
        String str2 = i.getStringExtra("height");
        TextView textResult =
                (TextView) findViewById(R.id.tvResultat);
        TextView textImc = (TextView) findViewById(R.id.tvImc);
        TextView textImcCategory =
                (TextView) findViewById(R.id.tvCategorie);
        float weight = 0;
        if (str1 != null) {
            weight = Float.parseFloat(str1);
        }
        float height = 0;
        if (str2 != null) {
            height = Float.parseFloat(str2) / 100;
        }
        float imcValeur = calculerIMC(weight, height);
        String imcInterpretation = interpreterIMC(imcValeur);
        if (str1 != null && str2 != null) {
            textResult.setText(String.format("%s a %s ans. Il pèse %skg pour une taille de %sm.", name, age, str1, str2));
        }
        textImc.setText(String.valueOf(imcValeur));
        textImcCategory.setText(String.format("Corpulence %s", imcInterpretation));
    }

    private float calculerIMC(float weight, float height) {
        return (float) (weight / (height * height));
    }

    private String interpreterIMC(float imcValeur) {
        if (imcValeur < 18.5) {
            return "Maigreur";
        } else if (18.5 < imcValeur && imcValeur < 24.9) {
            return "Normal";
        } else if (25 < imcValeur && imcValeur < 29.9) {
            return "Surpoids";
        } else if (30 < imcValeur && imcValeur < 40) {
            return "Obesité";
        } else {
            return "Obesité massive";

        }
    }
}