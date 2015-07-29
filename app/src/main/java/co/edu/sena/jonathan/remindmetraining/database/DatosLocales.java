package co.edu.sena.jonathan.remindmetraining.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import co.edu.sena.jonathan.remindmetraining.RemindApplication;
import co.edu.sena.jonathan.remindmetraining.data.Remind;

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
    private RemindApplication application;

    private class BdHelper extends SQLiteOpenHelper{

        public BdHelper(Context context) {
            super(context, BD_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + T_EVENTO + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NOMBRE + " TEXT, " + KEY_FOTO + " TEXT, " + KEY_AUDIO + " TEXT);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
           db.execSQL("DROP TABLE IF EXISTS " + T_EVENTO);
            onCreate(db);
        }
    }

    public DatosLocales(Context context) {
        this.context = context;
        application = (RemindApplication) context;
    }

    public void abrirBD(){
        nHelper = new BdHelper(context);
        nBD = nHelper.getWritableDatabase();
    }

    public void cerrarBD(){
        nHelper.close();
    }


    public void guardarDatos(String...datosRecividos){

        ContentValues cv = new ContentValues();

        cv.put(KEY_NOMBRE, datosRecividos[0]);
        cv.put(KEY_FOTO, datosRecividos[1]);
        cv.put(KEY_AUDIO, datosRecividos[2]);

        nBD.insert(T_EVENTO, null, cv);
    }

    public void cargarLista(){

        ArrayList<Remind> listaRecuerdos = new ArrayList<Remind>();

        Cursor c = nBD.rawQuery("select * from " + T_EVENTO, null);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){

            Remind recuerdo = new Remind();

            recuerdo.setId(c.getInt(0));
            recuerdo.setName(c.getString(1));
            recuerdo.setUrlFoto(c.getString(2));
            recuerdo.setUrlAudio(c.getString(3));

            listaRecuerdos.add(recuerdo);
        }

        application.setListaGridImagenes(listaRecuerdos);
    }
}
