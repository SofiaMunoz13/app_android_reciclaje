package com.example.ruben.appreciclaje;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setImageAction();
    }
    private void setImageAction() {
        ImageView imgPapel = (ImageView) findViewById(R.id.imagePapel);
        imgPapel.setOnClickListener(this);
        ImageView imgVidrio = (ImageView) findViewById(R.id.imageVidrio);
        imgVidrio.setOnClickListener(this);
        ImageView imgPlastico = (ImageView) findViewById(R.id.imagePlastico);
        imgPlastico.setOnClickListener(this);
        ImageView imgMetal = (ImageView) findViewById(R.id.imageMetal);
        imgMetal.setOnClickListener(this);
        ImageView imgBateria = (ImageView) findViewById(R.id.imageBateria);
        imgBateria.setOnClickListener(this);
        ImageView imgGoma = (ImageView) findViewById(R.id.imageGoma);
        imgGoma.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View view) {
        Intent activity;
        switch(view.getId()) {
            case R.id.imagePapel:
                activity = new Intent(MainActivity.this, CartonActivity.class);
                startActivity(activity);
                break;
            case R.id.imagePlastico:
                activity = new Intent(MainActivity.this, PlasticoActivity.class);
                startActivity(activity);
                break;
            case R.id.imageVidrio:
                activity = new Intent(MainActivity.this, VidrioActivity.class);
                startActivity(activity);
                break;
            case R.id.imageMetal:
                activity = new Intent(MainActivity.this, MetalActivity.class);
                startActivity(activity);
                break;
            case R.id.imageBateria:
                activity = new Intent(MainActivity.this, BateriaActivity.class);
                startActivity(activity);
                break;
            case R.id.imageGoma:
                activity = new Intent(MainActivity.this, GomaActivity.class);
                startActivity(activity);
                break;
        }
    }
}
