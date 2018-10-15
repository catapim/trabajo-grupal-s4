package e.francisco.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import e.francisco.base.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {


    Button btn_guardar_libro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrolibro);

        btn_guardar_libro = (Button) findViewById(R.id.btn_guardar_libro);

        @Override
        public void onClick(View v) {
            txtContent.setText(FileHelper.ReadFile(MainActivity.this));
        }
        





        //if (savedInstanceState == null) {
        //    getSupportFragmentManager().beginTransaction()
        //           .replace(R.id.container, MainFragment.newInstance())
        //           .commitNow();
        }
    }

}
