package com.example.aplicacionvacia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistarActividad extends AppCompatActivity {

    TextView textViewInformacionRecibida;
    Button buttonRegresarMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar_actividad);

        textViewInformacionRecibida = findViewById(R.id.textViewInformacionRecibida);
        buttonRegresarMain = findViewById(R.id.buttonRegresarMain);
        String datos = getIntent().getStringExtra("datos");
        textViewInformacionRecibida.setText(datos);

        buttonRegresarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}