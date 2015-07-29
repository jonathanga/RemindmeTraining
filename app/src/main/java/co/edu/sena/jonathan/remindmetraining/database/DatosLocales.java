package co.edu.sena.jonathan.remindmetraining.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Carmanu on 29/07/2015.
 */
public class DatosLocales {

    private static final String BD_NAME = "Remind_me";
    private static final String T_EVENTO = "Evento";

    public static final String KEY_ID = "Id_";
    public static final String KEY_NOMBRE = "Nombre_";
    public static final String KEY_FOTO = "Foto_";
    public static final String KEY_AUDIO = "Audio_";


    private Context context;
    private SQLiteDatabase nBD;
    private BdHelper nHelper;

    private class BdHelper extends SQLiteOpenHelper{

        public BdHelper(Context context) {
            super(context, BD_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    public DatosLocales(Context context) {
        this.context = context;
    }
}
