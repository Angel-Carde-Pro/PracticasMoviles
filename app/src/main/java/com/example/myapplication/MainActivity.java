package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMensaje;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id. generoSpinner);
        String [] respuestas = {"Masculino", "Femenino"};
        ArrayAdapter <String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, respuestas);
        spinner.setAdapter(adapter);
        Button buttonOK = findViewById(R.id.btnA1);
        buttonOK.setOnClickListener(l->enviarSMS(l));
    }
    public void enviarSMS(View view){
        Intent intent = new Intent(this, SegundaActivity.class);
                String generoS = spinner.getSelectedItem().toString();
                EditText editTextNombre = (EditText) findViewById(R.id.txtlabelNombre);
                EditText editTextApellido = (EditText) findViewById(R.id.txtlabelApellido);
                String mensaje = "Su nomnre es: " + editTextNombre.getText().toString() + "\nSu apellido es: " + editTextApellido.getText().toString() +
                        "\nSu genero es: " + generoS;
                intent.putExtra("mensa",mensaje);
                startActivity(intent); //Iniciamos segundo activity
    }

}