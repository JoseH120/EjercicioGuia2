package personal.app.ejercicioguia2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistrarActivity extends AppCompatActivity {

    TextView txvProgress;
    EditText edtNombre;
    Button btnGuardar;
    ProgressBar progressBar;
    Integer progressStatus = 0;
    Handler handler = new Handler();
    public static ArrayList<String> listNombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        edtNombre = findViewById(R.id.edtNombre);
        btnGuardar = findViewById(R.id.btnGuardar);
        txvProgress = findViewById(R.id.progressText);

        if(listNombres == null){
            listNombres = new ArrayList<>();
        }
    }

    public void GuardarRegistro(View view){
        if(edtNombre.getText().toString().isEmpty()){
            Toast.makeText(RegistrarActivity.this, "Debe de ingresar un nombre", Toast.LENGTH_SHORT).show();
        }
        else{
            //Toast.makeText(RegistrarActivity.this, "Guardado con exito", Toast.LENGTH_SHORT).show();
            if(progressStatus >= 100){
                progressStatus = 0;
                progressBar.setProgress(progressStatus);
            }
            progressBar.setVisibility(View.VISIBLE);
            new Hilo2().start();
            new Hilo().start();
            listNombres.add(edtNombre.getText().toString());
        }
    }

    class Hilo extends Thread{
        @Override
        public void run(){
            try{
                Thread.sleep(5500);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(RegistrarActivity.this, "nombre guardado", Toast.LENGTH_SHORT).show();
                        txvProgress.setText("");
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    class Hilo2 extends Thread{
        @Override
        public void run(){
            while(progressStatus < 100) {
                progressStatus += 10;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(progressStatus);
                        txvProgress.setText(progressStatus + "/" + progressBar.getMax());
                    }
                });
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

}