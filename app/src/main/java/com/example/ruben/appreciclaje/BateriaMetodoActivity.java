package com.example.ruben.appreciclaje;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class BateriaMetodoActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bateria_metodo);
        setMenu();
        setContent();
    }
    private void setContent() {
        ImageView carton = (ImageView) findViewById(R.id.btnImageCarton);
        ImageView bateria = (ImageView) findViewById(R.id.btnImageBateria);
        ImageView organica = (ImageView) findViewById(R.id.btnImageOrganico);
        ImageView metal = (ImageView) findViewById(R.id.btnImageMetal);
        ImageView plastico = (ImageView) findViewById(R.id.btnImagePlastico);
        ImageView vidrio = (ImageView) findViewById(R.id.btnImageVidrio);
        carton.setOnClickListener(this);
        bateria.setOnClickListener(this);
        organica.setOnClickListener(this);
        metal.setOnClickListener(this);
        plastico.setOnClickListener(this);
        vidrio.setOnClickListener(this);
    }
    private void setMenu() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()) {
            case R.id.fab:
                intent = new Intent(BateriaMetodoActivity.this, MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.btnImageCarton:
                intent = new Intent(BateriaMetodoActivity.this, CartonActivity.class);
                startActivity(intent);
                break;
            case R.id.btnImageVidrio:
                intent = new Intent(BateriaMetodoActivity.this, VidrioActivity.class);
                startActivity(intent);
                break;
            case R.id.btnImageMetal:
                intent = new Intent(BateriaMetodoActivity.this, MetalActivity.class);
                startActivity(intent);
                break;
            case R.id.btnImageOrganico:
                intent = new Intent(BateriaMetodoActivity.this, OrganicoActivity.class);
                startActivity(intent);
                break;
            case R.id.btnImagePlastico:
                intent = new Intent(BateriaMetodoActivity.this, PlasticoActivity.class);
                startActivity(intent);
                break;
            case R.id.btnImageBateria:
                intent = new Intent(BateriaMetodoActivity.this, BateriaActivity.class);
                startActivity(intent);
                break;
        }
    }
}
