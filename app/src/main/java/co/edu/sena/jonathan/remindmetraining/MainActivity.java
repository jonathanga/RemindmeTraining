package co.edu.sena.jonathan.remindmetraining;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import co.edu.sena.jonathan.remindmetraining.adapters.AdaptadorGridFotos;
import co.edu.sena.jonathan.remindmetraining.database.DatosLocales;


public class MainActivity extends Activity {

    GridView gridFotos;

    DatosLocales bdLocal;
    AdaptadorGridFotos adaptadorGridFotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bdLocal = new DatosLocales(getApplicationContext());
        cargarLista();
        adaptadorGridFotos = new AdaptadorGridFotos(getApplicationContext());
        init();
    }

    private void cargarLista() {
        try {
            bdLocal.abrirBD();
            bdLocal.cargarLista();
            bdLocal.cerrarBD();
        } catch (Exception e) {
            Log.e("Error:::_ ", e.toString());
        }
    }

    private void init() {
        gridFotos = (GridView) findViewById(R.id.main_grid_fotos);
        gridFotos.setAdapter(adaptadorGridFotos);
    }

}