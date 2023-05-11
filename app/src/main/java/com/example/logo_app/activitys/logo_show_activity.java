package com.example.logo_app.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.logo_app.R;
import com.example.logo_app.adapters.grid_adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class logo_show_activity extends AppCompatActivity {

    GridView gridView;
    List<String> image= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_show);
        gridView=findViewById(R.id.logo_show_grid);
        int pos=getIntent().getIntExtra("position",56);

        System.out.println("logo show pos =="+pos);
        String images[];
        try {
            if(pos==2){
                images=getAssets().list("solved");
                image=new ArrayList<>(Arrays.asList(images));
            }
            if(pos==4){
                images=getAssets().list("unsolved");
                image=new ArrayList<>(Arrays.asList(images));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("imagelist="+image);
     grid_adapter grid_adapter=new grid_adapter(logo_show_activity.this,image,pos);
     gridView.setNumColumns(3);
     gridView.setAdapter(grid_adapter);

    }
}