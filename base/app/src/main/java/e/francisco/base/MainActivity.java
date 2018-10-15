package e.francisco.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.ArrayList;

import e.francisco.base.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {


    Button btn_guardar_libro;
    private ArrayList<String> libros = new ArrayList<String>();
    private EditText intitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrolibro);

        libros = new ArrayList<String>();
        btn_guardar_libro = (Button) findViewById(R.id.btn_guardar_libro);

        intitulo = (EditText) findViewById(R.id.input_titulo);
        String ag=intitulo.getText().toString();
        libros.add(ag);
        intitulo.setText("");


        //if (savedInstanceState == null) {
        //    getSupportFragmentManager().beginTransaction()
        //           .replace(R.id.container, MainFragment.newInstance())
        //           .commitNow();
        }
    }
