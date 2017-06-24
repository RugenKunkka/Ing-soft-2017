package com.pk.appsoftware.appsoftware;

import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by scoles on 04/06/17.
 */

public class MyFileManager
{
    int contador;
    String path;
    File directorio;//filePath
    File[] archivos;
    ArrayList<File>listaDeArchivos;
    String[] fichs;

//   /sdcard/DCIM/Camera
    public MyFileManager()
    {
        contador=0;
        //path=ruta;
        path = Environment.getExternalStorageDirectory().toString()+"/DCIM/Camera/";
        //path=Environment.getDataDirectory().toString();
        directorio= new File(path);
        listaDeArchivos=new ArrayList<>();
        archivos=directorio.listFiles();
        fichs=directorio.list();

        if(archivos!=null)
        {
            for (File archivo : archivos)
            {

                if(archivo.getAbsolutePath().toString().endsWith(".jpg") && contador<100)
                {
                    archivo.getTotalSpace();//te da el espacio del archivo
                    archivo.getName();//te da el nombre del archivo
                    listaDeArchivos.add(archivo.getAbsoluteFile());
                    contador++;
                }

            }
        }
        else
        {
            //Toast.makeText(this, "NoExistenArchivos", Toast.LENGTH_SHORT).show();
        }

        //Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
    }


    public int getcantidadDeArchivos()
    {
        if(archivos!=null)
            return contador;
        else
            return 0;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public File getDirectorioFile() {
        return directorio;
    }

    public void setDirectorioFile(File directorio) {
        this.directorio = directorio;
    }

    public File[] getArchivos() {
        return archivos;
    }

    public void setArchivos(File[] archivos) {
        this.archivos = archivos;
    }

    public ArrayList<File> getListaDeArchivos() {
        return listaDeArchivos;
    }

    public void setListaDeArchivos(ArrayList<File> listaDeArchivos) {
        this.listaDeArchivos = listaDeArchivos;
    }
}
