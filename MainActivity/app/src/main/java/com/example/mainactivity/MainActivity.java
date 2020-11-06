package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculer_imc(View view) {
        EditText editText1 = (EditText)
                findViewById(R.id.nom);
        String n = editText1.getText().toString();
        EditText editText2 = (EditText)
                findViewById(R.id.poids);
        String p = editText2.getText().toString();
        EditText editText3 = (EditText)
                findViewById(R.id.taille);
        String t = editText3.getText().toString();
        EditText editText4 = (EditText)
                findViewById(R.id.age);
        String a = editText4.getText().toString();
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("name", n);
        intent.putExtra("weight", p);
        intent.putExtra("height", t);
        intent.putExtra("age", a);
        startActivity(intent);
    }
}