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

    private TextView[] imgDots;
    private SliderAdapter sliderAdapter;
    private LinearLayout sliderDots;
    private int currentPage = -1;
    private ViewPager mainSlider;

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

            currentPage++;
            //cambiar slider
            if(currentPage >= sliderAdapter.slider_images.length){
                currentPage = 0;
            }
            mainSlider.setCurrentItem(currentPage);
            addDotsIndicator(currentPage);

            handler.postDelayed(runnable, 5000);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);

        handler.post(runnable);

        mainSlider = findViewById(R.id.mainSlider);
        sliderDots = findViewById(R.id.sliderDots);

        sliderAdapter = new SliderAdapter(this);

        mainSlider.setAdapter(sliderAdapter);

        mainSlider.addOnPageChangeListener(viewListener);

        findViewById(R.id.imageMenu).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.imageMenu:
                PopupMenu settings = new PopupMenu(this, v);
                settings.getMenuInflater().inflate(R.menu.settings_popup, settings.getMenu());
                settings.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.itemWho:

                                break;

                            case R.id.itemWhere:
                                break;

                            case R.id.itemProd:
                                break;
                        }
                        return false;
                    }
                });
                settings.show();
                break;

        }
    }

    public void addDotsIndicator(int position){

        clearDots();

        imgDots = new TextView[sliderAdapter.slider_images.length];

        for(int i = 0; i < imgDots.length; i++){
            imgDots[i] = new TextView(this);
            imgDots[i].setText(Html.fromHtml("&#8226;"));
            imgDots[i].setTextSize(35);
            imgDots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            sliderDots.addView(imgDots[i]);
        }

        if(imgDots.length > 0){
            imgDots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }

    }

    public void clearDots(){
        sliderDots.removeAllViews();
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);
            currentPage = position;

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}