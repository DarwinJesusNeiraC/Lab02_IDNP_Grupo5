package com.example.aplicacionvacia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextPaterno, editTextMaterno, editTextNombres, editTextDateFecha, editTextCarrera;
    TextView textViewDate;
    Button buttonLista, buttonRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPaterno = findViewById(R.id.editTextPaterno);
        editTextMaterno = findViewById(R.id.editTextMaterno);
        editTextNombres = findViewById(R.id.editTextNombres);
        editTextCarrera = findViewById(R.id.editTextCarrera);

        textViewDate = findViewById(R.id.textViewDate);

        buttonLista = findViewById(R.id.buttonLista);
        buttonRegistrar = findViewById(R.id.buttonRegistrar);


        List<String> registrados = new ArrayList<>();

        textViewDate.setOnClickListener(view -> {
            Calendar calendario = Calendar.getInstance();
            int anio = calendario.get(Calendar.YEAR);
            int mes = calendario.get(Calendar.MONTH);
            int dia = calendario.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view1, year, monthOfYear, dayOfMonth) ->
                            textViewDate.setText(String.format("%02d/%02d/%04d", dayOfMonth, monthOfYear + 1, year)),
                    anio, mes, dia);

            datePickerDialog.show();
        });

        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editTextNombres.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Agrega texto", Toast.LENGTH_LONG);

                }
                else {
                    Intent intent = new Intent(MainActivity.this, RegistarActividad.class);
                    String datos = "Apellido Paterno: " + editTextPaterno.getText().toString()+ "\n"
                            + "Apellido Materno: " + editTextMaterno.getText().toString()+ "\n"
                            + "Nombres: " + editTextNombres.getText().toString()+ "\n"
                            + "Fecha: " + textViewDate.getText().toString()+ "\n"
                            + "Carrera: " + editTextCarrera.getText().toString()+ "\n";

                    intent.putExtra("datos",datos);
                    registrados.add(datos);
                    startActivity(intent);
                }
            }
        });

        buttonLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistradosLista.class);
                intent.putStringArrayListExtra("registrados", (ArrayList<String>) registrados);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // Borra los campos de texto
        editTextPaterno.setText("Apellido Paterno");
        editTextMaterno.setText("Apellido Materno");
        editTextNombres.setText("Nombres");
        textViewDate.setText("dd/mm/aaaa");
        editTextCarrera.setText("Carrera");
    }
}