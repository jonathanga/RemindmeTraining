package co.edu.sena.jonathan.remindmetraining;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.facebook.FacebookSdk;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;


public class DetalleActivity extends Activity {


    // TODO  Colocar la Imagen el BITMAP imagenMostrada
    Bitmap imagenMostrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_detalle);

        // TODO  Colocar la Imagen el BITMAP imagenMostrada
    }

    public void eliminarFoto(View view) {
    }

    public void compartirFacebook(View view) {
        // TODO  Colocar la Imagen el BITMAP imagenMostrada
        SharePhoto photo = new SharePhoto.Builder()
                .setBitmap(imagenMostrada)
                .build();
        SharePhotoContent content = new SharePhotoContent.Builder()
                .addPhoto(photo)
                .build();
    }
}
