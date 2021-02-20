package com.carlos.gohealthyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //logo principal
        ImageView logo = findViewById(R.id.mainLogo);
        //img loading
        ImageView load = findViewById(R.id.loading);
        //animacion logo principal
        Animation animacionLogo = AnimationUtils.loadAnimation(this, R.anim.animtitle);
        logo.startAnimation(animacionLogo);
        //animacion img loading
        Animation animacionLoad = AnimationUtils.loadAnimation(this, R.anim.loading);
        load.startAnimation(animacionLoad);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //abrimos el activity principal
                Intent i = new Intent(MainActivity.this,HomeMenu.class);
                startActivity(i);
                //acabamos con el activity actual para que no se pueda volver a él
                finish();

            }
        }, 5000); //delay de 5 segundos
    }
}