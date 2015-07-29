package co.edu.sena.jonathan.remindmetraining.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import co.edu.sena.jonathan.remindmetraining.R;
import co.edu.sena.jonathan.remindmetraining.RemindApplication;
import co.edu.sena.jonathan.remindmetraining.data.Remind;

/**
 * Created by Carmanu on 29/07/2015.
 */
public class AdaptadorGridFotos extends BaseAdapter {

    Context context;
    RemindApplication application;

    public AdaptadorGridFotos(Context context) {
        this.context = context;
        application = (RemindApplication) context;
    }

    @Override
    public int getCount() {
        return application.getListaGridImagenes().size();
    }

    @Override
    public Object getItem(int position) {
        return application.getListaGridImagenes().get(position);
    }

    @Override
    public long getItemId(int position) {
        return application.getListaGridImagenes().get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v;
        ImageView imgFoto;
        TextView txtNombre;

        if(convertView == null){
            v = View.inflate(context, R.layout.item_grid_fotos, null);
        }else{
            v= convertView;
        }

        Remind recuerdo = (Remind) getItem(position);

        txtNombre = (TextView) v.findViewById(R.id.grid_txt_nomnbre);
        imgFoto = (ImageView) v.findViewById(R.id.grid_img_foto);

        txtNombre.setText(recuerdo.getName());
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 3;
        Bitmap imagen = BitmapFactory.decodeFile(recuerdo.getUrlFoto(), options);
        imgFoto.setImageBitmap(imagen);

        return v;
    }
}
