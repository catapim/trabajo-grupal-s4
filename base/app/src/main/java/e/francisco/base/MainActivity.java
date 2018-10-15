package e.francisco.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String titulo, autor, publicacion, calificacion;
    EditText input_titulo;
    Button btn_guardar_libro;
    private ArrayList<String> libros = new ArrayList<String>();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrolibro);
        final EditText input_titulo = (EditText) findViewById(R.id.input_titulo);
        //EditText in_autor = (EditText) findViewById(R.id.input_autor);
        //EditText in_publicacion = (EditText) findViewById(R.id.input_publicacion);
        //EditText in_calificacion = (EditText) findViewById(R.id.input_calificacion);
        libros = new ArrayList<String>();
        System.out.println("holap");
        btn_guardar_libro = (Button) findViewById(R.id.btn_guardar_libro);
        btn_guardar_libro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titulo = input_titulo.getText().toString();
            }
        });
        }


      //  }
  //  )



}

