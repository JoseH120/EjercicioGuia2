package personal.app.ejercicioguia2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static personal.app.ejercicioguia2.RegistrarActivity.listNombres;

public class ListarActivity extends AppCompatActivity {
    ListView lsvNombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        lsvNombres = findViewById(R.id.lsvNombres);

        ArrayAdapter<String> adaptadorNombre = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listNombres);

        lsvNombres.setAdapter(adaptadorNombre);

        adaptadorNombre.notifyDataSetChanged();
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