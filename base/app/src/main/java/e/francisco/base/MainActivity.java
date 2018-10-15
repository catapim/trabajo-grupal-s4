package e.francisco.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText input_titulo = (EditText) findViewById(R.id.input_titulo);
    EditText in_autor = (EditText) findViewById(R.id.input_autor);
    EditText in_publicacion = (EditText) findViewById(R.id.input_publicacion);
    EditText in_calificacion = (EditText) findViewById(R.id.input_calificacion);
    //btn_guardar_libro = (Button) findViewByID(R.id.btn_guardar_libro);
   // btn_guardar_libro.setOnClickListener(new View.OnclickListener(){

      //  }
  //  )
    private ArrayList<String> libros = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrolibro);
        libros = new ArrayList<String>();
        System.out.println("holap");

    }
}

