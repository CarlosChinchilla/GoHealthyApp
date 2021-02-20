package com.carlos.gohealthyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

/**
 * Clase del adaptador del slider
 */
public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    //Array de las imagenes del slider
    public int[] slider_images = {

            R.drawable.confianza,
            R.drawable.atencioncliente,
            R.drawable.internacional,
            R.drawable.resultados

    };

    //Array de los TITULOS del slider
    public String[] slider_titles = {
            "CONFIANZA",
            "ATENCIÓN PERSONALIZADA",
            "INTERNACIONAL",
            "RESULTADOS"
    };

    //Array de los DESCRIPCIONES del slider
    public String[] slider_descriptions = {
            "En GoHealthy las personas son lo primero por eso somos líderes en confianza " +
                    "entre nuestros partners.",
            "En GoHealthy no hablarás con máquinas. Todas las consultas son atendidas por " +
                    "personas altamente cualificadas para resolver cualquier incidencia.",
            "GoHealthy trabaja y colabora con empresas y asociaciones a nivel mundial. " +
                    "Para nosotros no existen fronteras.",
            "GoHealthy garantiza la satisfacción del cliente. Nuestro equipo le ayudará a " +
                    "encontrar la mejor solución a aplicarla a su situación específica."
    };


    @Override
    public int getCount() {
        return slider_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);

        ImageView sliderImage = view.findViewById(R.id.imageSlider);
        TextView textTitle = view.findViewById(R.id.textTitulo);
        TextView textDescription = view.findViewById(R.id.textDescripcion);

        sliderImage.setImageResource(slider_images[position]);
        textTitle.setText(slider_titles[position]);
        textDescription.setText(slider_descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);

    }
}
