package com.example.logo_app.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.logo_app.R;
import com.example.logo_app.adapters.grid_adapter;

import java.io.IOException;

public class logo_show_activity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_show);
        gridView=findViewById(R.id.logo_show_grid);
        String images[];
        try {
             images=getAssets().list("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        grid_adapter grid_adapter=new grid_adapter(logo_show_activity.this,);

    }
}