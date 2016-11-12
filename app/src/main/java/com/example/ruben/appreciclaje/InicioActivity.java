package com.example.ruben.appreciclaje;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class InicioActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        setMenu();
        setContent();
    }
    private void setMenu() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }
    private void setContent() {
        ImageView imgVidrio = (ImageView) findViewById(R.id.imageVidrio);
        imgVidrio.setOnClickListener(this);
        ImageView imgPlastico = (ImageView) findViewById(R.id.imagePlastico);
        imgPlastico.setOnClickListener(this);
        ImageView imgMetal = (ImageView) findViewById(R.id.imageMetal);
        imgMetal.setOnClickListener(this);
        ImageView imgBateria = (ImageView) findViewById(R.id.imageBateria);
        imgBateria.setOnClickListener(this);
        ImageView imgOrganico = (ImageView) findViewById(R.id.imageOrganico);
        imgOrganico.setOnClickListener(this);
        ImageView imgPapel = (ImageView) findViewById(R.id.imagePapel);
        imgPapel.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent activity;
        switch(view.getId()) {
            case R.id.fab:
                activity = new Intent(this, ReportActivity.class);
                startActivity(activity);
                break;
            case R.id.imagePlastico:
                activity = new Intent(this, PlasticoActivity.class);
                startActivity(activity);
                break;
            case R.id.imageVidrio:
                activity = new Intent(this, VidrioActivity.class);
                startActivity(activity);
                break;
            case R.id.imageMetal:
                activity = new Intent(this, MetalActivity.class);
                startActivity(activity);
                break;
            case R.id.imageBateria:
                activity = new Intent(this, BateriaActivity.class);
                startActivity(activity);
                break;
            case R.id.imageOrganico:
                activity = new Intent(this, OrganicoActivity.class);
                startActivity(activity);
                break;
            case R.id.imagePapel:
                activity = new Intent(this, CartonActivity.class);
                startActivity(activity);
                break;
        }
    }
}
