package com.example.ruben.appreciclaje;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class CartonActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carton);
        getCabecera();
        setContent();
    }
    private void setContent() {
        Button btn=(Button)findViewById(R.id.btnCartonMethod);
        btn.setOnClickListener(this);
    }
    private void getCabecera() {Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.fab:
                intent=new Intent(CartonActivity.this,MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.btnCartonMethod:
                intent=new Intent(CartonActivity.this,CartonMetodoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
