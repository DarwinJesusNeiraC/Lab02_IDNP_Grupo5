package com.example.aplicacionvacia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class RegistradosLista extends AppCompatActivity {

    private ListView ListViewLista;
    private ArrayAdapter<String> adapter;
    Button buttonRegresarMainLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrados_lista);
        buttonRegresarMainLista = findViewById(R.id.buttonRegresarMainLista);

        List<String> registrados = getIntent().getStringArrayListExtra("registrados");
        ListViewLista = findViewById(R.id.ListViewLista);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, registrados);
        ListViewLista.setAdapter(adapter);
        buttonRegresarMainLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}