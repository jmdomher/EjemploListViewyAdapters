package com.example.profesor.ejemplolistviewyadapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Obtenemos referencia al singleton con la lista de quesos

    String[] QUESOS = ListaQuesos.getInstance().getQuesos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Creamos adaptador
        ArrayAdapter<String> quesoAdapter = new ArrayAdapter<>(
                this,
                R.layout.layout_item_queso, // XML con layout de item
                R.id.nombre_queso_texview, // textview dentro de xml que contendra dato
                QUESOS);

        // Creamos el ListView
        ListView listaQuesos = new ListView(this);

        // Hace el inflate del ListView dentro de la actividad.
        // Ocupara todo la pantalla
        setContentView(listaQuesos);

        // Enlaza el Adapter a la listview
        listaQuesos.setAdapter(quesoAdapter);

        // Generamos Listeners para recoger el vento de onclick sobre un item de la lista

        listaQuesos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Código a ejecutar cuando se produce el evento
                // Generamos un mensaje basado en la posición en el array del item pulsado
                String mensaje = "Has pulsado QUESOS["+ position +"] --> " + QUESOS[position];

                // Mostramos el mensaje usando un Toast

                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
            }
        });

    }
}
