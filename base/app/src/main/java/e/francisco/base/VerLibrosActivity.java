package e.francisco.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.util.Log;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class VerLibrosActivity extends AppCompatActivity {

    TextView added_book;
    TextView added_autor;
    TextView added_publicacion;
    TextView added_calificacion;
    ArrayList<String> book_strings=new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ver_libros);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Context context = getBaseContext();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private String readFromFile(Context context) {
        System.out.println("leyendo archivos");
        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("config.txt");

            if ( inputStream != null ) {
                System.out.println("archivo listo para ser leido");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                    System.out.println(receiveString);
                    book_strings.add(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
                System.out.println(ret);
            } else {
                System.out.println("no se ha podido leer");
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    protected void onStart() {
        super.onStart();
        readFromFile(getBaseContext());
        // TODO: leer los otros libros que estan en el array book_strings
        String[] datos = book_strings.get(0).split(",");

        added_book = findViewById(R.id.added_book);
        added_book.setText(datos[0]);
        added_autor = findViewById(R.id.added_autor);
        added_autor.setText(datos[1]);
        added_publicacion = findViewById(R.id.added_publicacion);
        added_publicacion.setText(datos[2]);
        added_calificacion = findViewById(R.id.added_calificacion);
        added_calificacion.setText(datos[3]);

    }
}
