package com.carlos.gohealthyapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class WhoWeAre extends AppCompatActivity {

    private OnboardingAdapter onboardingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_wwa);

        setupOnboardingItems();

        ViewPager2 onboardingViewPager = findViewById(R.id.onboardingVP);
        onboardingViewPager.setAdapter(onboardingAdapter);
    }

    private void setupOnboardingItems(){
        List<OnboardingItem> onboardingItems = new ArrayList<>();

        OnboardingItem itemPrincipal= new OnboardingItem();
        itemPrincipal.setTitle("¿Quiénes Somos?");
        itemPrincipal.setDescription("Nuestra misión como grupo GoHealthy es ofrecer tú bienestar");
        itemPrincipal.setImage(R.drawable.wwa);

        OnboardingItem itemCarlos = new OnboardingItem();
        itemCarlos.setTitle("Analista");
        itemCarlos.setDescription("Encargado de desarrollar y organizar proyectos mediante el uso de las Tecnologías de Información");
        itemCarlos.setImage(R.drawable.chcc);

        OnboardingItem itemBrenda = new OnboardingItem();
        itemBrenda.setTitle("Programadora");
        itemBrenda.setDescription("Encargada de estructurar el diseño de proyectos eficientes, rápidos y versátiles");
        itemBrenda.setImage(R.drawable.bsbs);


        OnboardingItem itemJorge = new OnboardingItem();
        itemJorge.setTitle("Programador");
        itemJorge.setDescription("Encargado de estructurar el diseño de proyectos eficientes, rápidos y versátiles");
        itemJorge.setImage(R.drawable.jf);


        onboardingItems.add(itemPrincipal);
        onboardingItems.add(itemCarlos);
        onboardingItems.add(itemBrenda);
        onboardingItems.add(itemJorge);

        onboardingAdapter = new OnboardingAdapter(onboardingItems);
    }
}