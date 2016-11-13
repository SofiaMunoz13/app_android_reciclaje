package com.example.ruben.appreciclaje;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings.Secure;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruben.appreciclaje.conexion.Conexion;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportActivity extends AppCompatActivity implements View.OnClickListener {
    protected View mProgressView;
    protected View mLoginFormView;
    protected String nameUser;
    protected AsyncHttpClient client;
    protected RequestParams params;
    private final String ruta_fotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/misfotos/";
    private File file = new File(ruta_fotos);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton botonRep = (FloatingActionButton) findViewById(R.id.btnReport);
        botonRep.setOnClickListener(this);
        FloatingActionButton boton = (FloatingActionButton) findViewById(R.id.btnCamera);
        //Si no existe crea la carpeta donde se guardaran las fotos
        file.mkdirs();
        boton.setOnClickListener(this);
    }
    private void sendReport() {
        Toast.makeText(this,"Enviando",Toast.LENGTH_SHORT).show();
        showProgress(true);
        String id = "1";
        client = new AsyncHttpClient();
        params = new RequestParams();
        params.put("nameUser", id);
        params.put("android", "android");
        RequestHandle post = client.post(Conexion.getUrlServer(1), params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode == 200) {
                    try {
                        JSONObject obj = new JSONObject(new String(responseBody));
                        Intent intent = new Intent(ReportActivity.this, InicioActivity.class);
                        startActivity(intent);
                        showProgress(false);
                    } catch(JSONException e) {
                        showProgress(false);
                        Toast.makeText(ReportActivity.this, "Error de consulta site tour", Toast.LENGTH_LONG).show();
                    }
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                showProgress(false);
                Toast.makeText(ReportActivity.this, "No se ha podido establecer conecion con el servidor", Toast.LENGTH_LONG).show();
            }
        });
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    protected void showProgress(final boolean show) {
        /*if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }*/
    }
    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()) {
            case R.id.fab:
                intent = new Intent(ReportActivity.this, MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.btnCamera:
                String file = ruta_fotos+"123456.jpg";
                File mi_foto = new File(file);
                try {
                    mi_foto.createNewFile();
                } catch(IOException ex) {
                    Log.e("ERROR ", "Error:"+ex);
                }
                //
                Uri uri = Uri.fromFile(mi_foto);
                //Abre la camara para tomar la foto
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //Guarda imagen
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                //Retorna a la actividad
                startActivityForResult(cameraIntent, 0);
                TextView text=(TextView)findViewById(R.id.imagePhoto);
                text.setText(ruta_fotos);
                break;
            case R.id.btnReport:
                sendReport();
        }
    }
}
