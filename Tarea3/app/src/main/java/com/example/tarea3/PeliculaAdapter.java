package com.example.tarea3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PeliculaAdapter extends ArrayAdapter<String> {

    private final String[] peliculas;
    private final String[] generos;
    private final int[] imagenes;

    // Constructor del adaptador
    public PeliculaAdapter(Context context,
                           String[] peliculas,
                           String[] generos,
                           int[] imagenes) {

        super(context, R.layout.item_pelicula, peliculas);

        this.peliculas = peliculas;
        this.generos = generos;
        this.imagenes = imagenes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Reutilizamos la vista
        View vista = convertView;

        if (vista == null) {
            vista = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_pelicula, parent, false);
        }

        //Obtenemos los componentes del XML
        ImageView imagenPelicula =
                vista.findViewById(R.id.imagenPelicula);

        TextView nombrePelicula =
                vista.findViewById(R.id.nombrePelicula);

        TextView generoPelicula =
                vista.findViewById(R.id.generoPelicula);

        //Colocamos la info
        imagenPelicula.setImageResource(imagenes[position]);
        nombrePelicula.setText(peliculas[position]);
        generoPelicula.setText(generos[position]);

        return vista;
    }
}