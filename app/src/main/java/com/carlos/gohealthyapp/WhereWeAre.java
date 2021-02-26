package com.carlos.gohealthyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class WhereWeAre extends AppCompatActivity  implements View.OnClickListener{

    private Button botonMap;
    private ImageButton botonAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.where_we_are);

        botonMap = (Button)findViewById(R.id.bMap);
        botonMap.setOnClickListener(this);

        botonAtras = (ImageButton)findViewById(R.id.ibAtras);
        botonAtras.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bMap:
                Intent intent = new Intent(this, MapsActivityGH.class);
                startActivity(intent);
                break;
            case R.id.ibAtras:
                finish();
                break;
        }


    }
}
