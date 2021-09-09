package personal.app.ejercicioguia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static personal.app.ejercicioguia2.RegistrarActivity.listNombres;

public class MainActivity extends AppCompatActivity {

    Button btnAgregar, btnListar, btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAgregar = findViewById(R.id.btnAgregar);
        btnListar = findViewById(R.id.btnVerLista);
        btnMostrar = findViewById(R.id.btnMostrarDatos);
    }

    public void agregarNombres(View view){
        startActivity(new Intent(MainActivity.this, RegistrarActivity.class));
    }

    public void mostrarDatos(View view){
        startActivity(new Intent(MainActivity.this, MostrarActivity.class));
    }

    public void listarNombres(View view){
        if(listNombres == null || listNombres.isEmpty()){
            Toast.makeText(MainActivity.this, "Lista Vacia", Toast.LENGTH_SHORT).show();
        }else{
            startActivity(new Intent(MainActivity.this, ListarActivity.class));
        }
    }

}