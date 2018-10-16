package e.francisco.base;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText input_titulo;
    EditText input_autor;
    EditText input_publicacion;
    EditText input_calificacion;
    String titulo, autor, publicacion, calificacion;
    Button btn_guardar_libro;
    Button btn_ver_libro;
    TextView show_titulo, show_autor, show_publicacion, show_calificacion;

    //public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/aaBiblioteca";

    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", MainActivity.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch(IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrolibro);
        final Context context = getBaseContext();

        final EditText input_titulo = (EditText) findViewById(R.id.input_titulo);
        final EditText input_autor = (EditText) findViewById(R.id.input_autor);
        final EditText input_publicacion = (EditText) findViewById(R.id.input_publicacion);
        final EditText input_calificacion = (EditText) findViewById(R.id.input_calificacion);

        //show_titulo = (TextView) findViewById(R.id.show_titulo);
        //show_autor = (TextView) findViewById(R.id.show_autor);
        //System.out.println("holap");
        //File dir = new File(path);
        //dir.mkdirs();

        btn_guardar_libro = (Button) findViewById(R.id.btn_guardar_libro);
        btn_guardar_libro.setOnClickListener(new View.OnClickListener() {
            private View view;
            @Override
            public void onClick(View v) {
                titulo = input_titulo.getText().toString();
                autor = input_autor.getText().toString();
                publicacion = input_publicacion.getText().toString();
                calificacion = input_calificacion.getText().toString();
                writeToFile(titulo,getBaseContext());
                writeToFile(autor,getBaseContext());
                writeToFile(publicacion,getBaseContext());
                writeToFile(calificacion,getBaseContext());
                //File file = new File (path+"/libros.txt");
                //  String[] saveText = String.valueOf(input_titulo.getText().toString()).split(System.getProperty("comma.separator"));
                //input_titulo.setText();
                //   Toast.makeText(getApplicationContext(), "Guardado",Toast.LENGTH_SHORT).show();
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
    public void openVerLibrosActivity() {
        Intent intent = new Intent(this, VerLibrosActivity.class);
        startActivity(intent);
    }

//    private void showToast(String text) {
  //      Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
   // }

    private class MODE_PRIVATE {
    }
}

