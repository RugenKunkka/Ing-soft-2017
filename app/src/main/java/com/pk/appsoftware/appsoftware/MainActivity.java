package com.pk.appsoftware.appsoftware;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonCargar=(Button) findViewById(R.id.boton_cargar);
        botonCargar.setOnClickListener(this);

    }


    @Override
    public void onClick(View view)
    {
        if(view.getId()==R.id.boton_cargar)
        {
            //Toast.makeText(this, "APRETASTE EL BOTON CARGAR PIBE!!!", Toast.LENGTH_SHORT).show();
            Intent intentCargar=new Intent(this, CargarActivity.class);
            startActivity(intentCargar);
        }

    }
}
