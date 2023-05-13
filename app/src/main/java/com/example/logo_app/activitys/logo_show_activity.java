package com.example.logo_app.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        int pos=getIntent().getIntExtra("pos",0);

        System.out.println("logo show pos =="+pos);
        String images[];
        try {
            if(pos==0){
                images=getAssets().list("level_1_us/");
                image=new ArrayList<>(Arrays.asList(images));
            }
            if(pos==1){
                images=getAssets().list("level_2_us/");
                image=new ArrayList<>(Arrays.asList(images));
            }if(pos==2){
                images=getAssets().list("level_3_us/");
                image=new ArrayList<>(Arrays.asList(images));
            }
            if(pos==3){
                images=getAssets().list("level_4_us/");
                image=new ArrayList<>(Arrays.asList(images));
            }if(pos==4){
                images=getAssets().list("level_5_us/");
                image=new ArrayList<>(Arrays.asList(images));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

     grid_adapter grid_adapter=new grid_adapter(logo_show_activity.this,image,pos);
     gridView.setNumColumns(3);
     gridView.setAdapter(grid_adapter);
     gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             Intent intent= new Intent(logo_show_activity.this,logo_play_activity.class);
             intent.putExtra("asset",pos);
             intent.putExtra("imgpos",position);
             intent.putExtra("list", image.get(position));
             startActivity(intent);
         }
     });

    }
}