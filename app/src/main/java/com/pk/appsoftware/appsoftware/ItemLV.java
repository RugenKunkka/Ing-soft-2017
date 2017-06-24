package com.pk.appsoftware.appsoftware;

import android.graphics.Bitmap;

/**
 * Created by scoles on 04/06/17.
 */

public class ItemLV
{

    String nombre;
    float peso;
    String bitmap;


    public ItemLV(String nombre, float peso, String bitmap)
    {
        this.nombre=nombre;
        this.peso=peso;
        this.bitmap=bitmap;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getBitmap() {
        return bitmap;
    }

    public void setBitmap(String bitmap) {
        this.bitmap = bitmap;
    }
}
