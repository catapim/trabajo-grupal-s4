package e.francisco.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText input_titulo;
    EditText input_autor;
    EditText input_publicacion;
    EditText input_calificacion;
    String titulo, autor, publicacion, calificacion;
    Button btn_guardar_libro;
    Button btn_ver_libro;
    TextView show_titulo, show_autor, show_publicacion, show_calificacion;

    private ArrayList<String> libros = new ArrayList<String>();

    @Override
        protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrolibro);
        final EditText input_titulo = (EditText) findViewById(R.id.input_titulo);
        final EditText input_autor = (EditText) findViewById(R.id.input_autor);
        final EditText input_publicacion = (EditText) findViewById(R.id.input_publicacion);
        final EditText input_calificacion = (EditText) findViewById(R.id.input_calificacion);
        libros = new ArrayList<String>();

        show_titulo = (TextView) findViewById(R.id.show_titulo);
        show_autor = (TextView) findViewById(R.id.show_autor);

        System.out.println("holap");
        btn_guardar_libro = (Button) findViewById(R.id.btn_guardar_libro);
        btn_guardar_libro.setOnClickListener(new View.OnClickListener() {

            private View view;

            @Override
            public void onClick(View v) {
                titulo = input_titulo.getText().toString();
                autor = input_autor.getText().toString();
                publicacion = input_publicacion.getText().toString();
                calificacion = input_calificacion.getText().toString();

                showToast(titulo);
                showToast(autor);
                showToast(String.valueOf(publicacion));
                showToast(String.valueOf(calificacion));
            }
        });

        btn_ver_libro = (Button) findViewById(R.id.btn_ver_libro);
        btn_ver_libro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVerLibrosActivity();
            }
        });


    }

    private void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public void  openVerLibrosActivity(){
        Intent intent = new Intent(this, VerLibrosActivity.class);
        startActivity(intent);
    }

    private void showToast(String text) {
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            show_titulo.setText(titulo);
            show_autor.setText(autor);
           // show_publicacion.setText(publicacion);
            //show_calificacion.setText(calificacion);
    }
}

