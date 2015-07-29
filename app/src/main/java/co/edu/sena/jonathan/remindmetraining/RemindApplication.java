package co.edu.sena.jonathan.remindmetraining;

import android.app.Application;

import java.util.ArrayList;

import co.edu.sena.jonathan.remindmetraining.data.Remind;

/**
 * Created by Carmanu on 29/07/2015.
 */
public class RemindApplication extends Application {

    private ArrayList<Remind> listaGridImagenes;

    public ArrayList<Remind> getListaGridImagenes() {
        return listaGridImagenes;
    }

    public void setListaGridImagenes(ArrayList<Remind> listaGridImagenes) {
        this.listaGridImagenes = listaGridImagenes;
    }
}
