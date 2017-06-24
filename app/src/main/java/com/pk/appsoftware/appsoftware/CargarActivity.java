package com.pk.appsoftware.appsoftware;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class CargarActivity extends AppCompatActivity implements View.OnClickListener
{


    ArrayList<ItemLV> items;
    MyFileManager fileManager;
    ImageView imagenDinamica;
    ListView listView;

    File imgFile;
    Bitmap miBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar);

        fileManager=new MyFileManager();
        //imgFile = new File(Environment.getExternalStorageDirectory().toString()+"/DCIM/Camera/IMG_20170417_143412.jpg");
        imgFile = new File(Environment.getExternalStorageDirectory().toString()+"/DCIM/Camera/icono.jpg");
        //imgFile= fileManager.getListaDeArchivos().get(0);
        miBitmap= BitmapFactory.decodeFile(imgFile.getAbsolutePath());

        Button botonDatos=(Button) findViewById(R.id.boton_datos);
        botonDatos.setOnClickListener(this);//me esta dando problemas este hdmp!!


        imagenDinamica=(ImageView) findViewById(R.id.imagen_dinamica);

        items=new ArrayList<ItemLV>();

        CrearLV();

        itemsView();

    }


    public void CrearLV()
    {
        for(File archivito:fileManager.getListaDeArchivos())
        {
            items.add( new ItemLV(archivito.getName(),(float) archivito.getTotalSpace(), archivito.getAbsolutePath()) );
        }

    }


    public void itemsView()
    {
        ArrayAdapter<ItemLV> adapterItemLV = new MyListAdapter();
        listView= (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapterItemLV);//el ptoblema esta aca!!!

    }

    private class MyListAdapter extends ArrayAdapter<ItemLV>
    {
        public MyListAdapter()
        {
            super(CargarActivity.this,R.layout.layout_item,items);
        }
        //aca reemplazas el view del LV


        public View getView(int position, View convertView, ViewGroup parent)
        {
            /*View itemView=convertView;

            if(itemView==null)
                itemView=getLayoutInflater().inflate(R.layout.layout_item,parent,false);


            ItemLV currentItemLV=items.get(position);//estp esta mal fijate...

            ImageView iconoArchivo= (ImageView) itemView.findViewById(R.id.image_item_generico);
            //iconoArchivo.setImageBitmap(currentItemLV.getBitmap());//ya sabes lo q tenes que hacer aca;
            iconoArchivo.setImageBitmap(BitmapFactory.decodeFile(currentItemLV.getBitmap()));


            TextView textViewNombre= (TextView) findViewById(R.id.text_item_generic_1);
            textViewNombre.setText("LCDTM en 3D");

            TextView textViewPeso= (TextView) findViewById(R.id.text_item_generic_2);
            textViewPeso.setText("LCDTM en 3MB");
            */
            View itemView=convertView;

            if(itemView==null)
                itemView=getLayoutInflater().inflate(R.layout.layout_item,parent,false);

            //View itemView = LayoutInflater.from(getContext()).inflate(R.layout.layout_item,parent,false);
            ItemLV currentItemLV=items.get(position);

            ImageView iconoArchivo=(ImageView) itemView.findViewById(R.id.image_item_generico);
            TextView textViewNombre=(TextView) itemView.findViewById(R.id.text_item_generic_1);
            TextView textViewPeso=(TextView) itemView.findViewById(R.id.text_item_generic_2);

            //iconoArchivo.setImageBitmap();
            Bitmap bm=BitmapFactory.decodeFile(currentItemLV.getBitmap());
            //iconoArchivo.setImageBitmap(Bitmap.createScaledBitmap(bm,bm.getWidth()/40,bm.getHeight()/40,true));
            iconoArchivo.setImageBitmap(miBitmap);

            //iconoArchivo.setImageBitmap(BitmapFactory.decodeFile(currentItemLV.getBitmap()));



            textViewNombre.setText("Nombre: "+currentItemLV.getNombre());
            textViewPeso.setText("Peso: " + currentItemLV.getPeso());


            return itemView;

        }
    }


    @Override
    public void onClick(View view)
    {
        if(view.getId()==R.id.boton_datos)
        {
            //Toast.makeText(this,"El path es: " + fileManager.getLastName(), Toast.LENGTH_LONG).show();
            Toast.makeText(this,"El path es: " + Integer.toString(fileManager.getcantidadDeArchivos()), Toast.LENGTH_LONG).show();
            //imagenDinamica.setImageBitmap(miBitmap.reconfigure(64,64, Bitmap.Config.ARGB_4444);;
            //imagenDinamica.setMaxHeight(20);
            //imagenDinamica.setMaxWidth(20);
        }

    }
}
