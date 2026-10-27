package com.example.tarea3;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ListView listaPeliculas;
    // Películas disponibles en la cartelera
    private final String[] peliculas = {
            "Ready Player One",
            "Swing Girls",
            "Evil Dead",
            "Street Fighter",
            "Kill Bill",
            "Forest Gump",
            "Sangre por sangre",
            "Spider-Man 2"
    };

    // Géneros de las películas
    private final String[] generos = {
            "Ciencia ficción",
            "Comedia / Musical",
            "Terror",
            "Acción",
            "Acción",
            "Drama",
            "Drama / Crimen",
            "Acción / Superhéroes"
    };

    // Pósteres de las películas
    private final int[] imagenes = {
            R.drawable.ready_poster,
            R.drawable.swing_poster,
            R.drawable.evil_poster,
            R.drawable.streetfighter_poster,
            R.drawable.killbill_poster,
            R.drawable.forestgump_poster,
            R.drawable.bloodinbloodout_poster,
            R.drawable.spiderman2_poster
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        // Interfaz principal

        //Interfaz de listas
        setContentView(R.layout.activity_lista);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(android.R.id.content),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        //Obtenemos la referencia al ListView del XML
        listaPeliculas = findViewById(R.id.listaPeliculas);

        PeliculaAdapter adaptador = new PeliculaAdapter(
                this,
                peliculas,
                generos,
                imagenes
        );

        //Asociamos el adaptador con el ListView
        listaPeliculas.setAdapter(adaptador);

        // Evento al seleccionar una película
        listaPeliculas.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(
                            AdapterView<?> parent,
                            android.view.View view,
                            int position,
                            long id
                    ) {

                        //Obtenemos la película seleccionada
                        String peliculaSeleccionada = peliculas[position];

                        //Mostramos un mensaje
                        Toast.makeText(
                                MainActivity.this,
                                "Seleccionaste: " + peliculaSeleccionada,
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );
    }
}