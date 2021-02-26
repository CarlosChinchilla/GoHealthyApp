package com.carlos.gohealthyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

public class HomeMenu extends AppCompatActivity implements View.OnClickListener {

    private TextView[] imgDots; //Array de textviews con el marcador de la posicion del slider
    private SliderAdapter sliderAdapter; //adaptador del slider
    private LinearLayout sliderDots; //LinearLayout que contendra los marcadores del slider
    private int currentPage = -1; //pagina inicial del slider
    private ViewPager mainSlider; //ViewPager del slider

    //Handler para controlar el tiempo de transicion del slider
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

            //aumentamos la pagina del slider
            currentPage++;
            //si el slider llega al final vuelve a comenzar
            if(currentPage >= sliderAdapter.slider_images.length){
                currentPage = 0;
            }
            //marcamos el contenido de la pagina del slider
            mainSlider.setCurrentItem(currentPage);
            //marcamos el indicador de la pagina del slider donde nos encontramos
            addDotsIndicator(currentPage);

            //marcamos el delay de 5 minutos del handler
            handler.postDelayed(runnable, 5000);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);

        //iniciamos el handler
        handler.post(runnable);

        //instanciamos el slider y el marcador del mismo
        mainSlider = findViewById(R.id.mainSlider);
        sliderDots = findViewById(R.id.sliderDots);

        //creamos el slider
        sliderAdapter = new SliderAdapter(this);
        //aplicamos el adapter
        mainSlider.setAdapter(sliderAdapter);
        //listener de la pagina actual del slider
        mainSlider.addOnPageChangeListener(viewListener);

        //listener del menu desplegable
        findViewById(R.id.imageMenu).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            //menu desplegable
            case R.id.imageMenu:
                PopupMenu settings = new PopupMenu(this, v);
                settings.getMenuInflater().inflate(R.menu.settings_popup, settings.getMenu());
                settings.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.itemWho:
                                //ACTIVITY DE "QUIENES SOMOS"
                                Intent i = new Intent(HomeMenu.this, WhoWeAre.class);
                                startActivity(i);
                                break;

                            case R.id.itemWhere:
                                //ACTIVITY DE "DONDE ESTAMOS"
                                Intent e = new Intent(HomeMenu.this, WhereWeAre.class);
                                startActivity(e);
                                break;

                            case R.id.itemProd:
                                //ACTIVITY DE "NUESTROS PRODUCTOS"
                                Intent t = new Intent(HomeMenu.this, OurProducts.class);
                                startActivity(t);
                                break;
                        }
                        return false;
                    }
                });
                settings.show();
                break;
        }
    }

    /**
     * Método Que actualiza el indicador de la posición del slider
     *
     * @param position posicion actual del slider
     */
    public void addDotsIndicator(int position){

        //Método que reinicia el indicador
        clearDots();
        //creamos los textviews
        imgDots = new TextView[sliderAdapter.slider_images.length];

        //bucle para crear los indicadores
        for(int i = 0; i < imgDots.length; i++){
            //creamos el textview y añadimos sus propiedades
            imgDots[i] = new TextView(this);
            imgDots[i].setText(Html.fromHtml("&#8226;"));
            imgDots[i].setTextSize(35);
            imgDots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            //añadimos el textview
            sliderDots.addView(imgDots[i]);
        }

        //cambiamos el color del indicador de la pagina actual
        if(imgDots.length > 0){
            imgDots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

    /**
     * Método que reinicia el indicador
     */
    public void clearDots(){

        //vacia el contenido del indicador
        sliderDots.removeAllViews();
    }

    //listener del cambio de pagina del slider
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

        //al cambiar de pagina del slider
        @Override
        public void onPageSelected(int position) {

            //actualizamos el indicador
            addDotsIndicator(position);
            //actualizamod el contenido del slider
            currentPage = position;

        }

        @Override
        public void onPageScrollStateChanged(int state) {}
    };
}