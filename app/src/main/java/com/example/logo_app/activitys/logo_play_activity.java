package com.example.logo_app.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.logo_app.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class logo_play_activity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    Button btn[]= new Button[14];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_play);
        imageView=findViewById(R.id.play_image);
        init();
        btn[0].setOnClickListener(this);
       int pos=getIntent().getIntExtra("imgpos",0);
       int asaetpos=getIntent().getIntExtra("asset",0);
       String s = getIntent().getStringExtra("list");
        System.out.println("Img="+s);
        InputStream stream=null;
        try {
            if(asaetpos==0){
                stream=getAssets().open("level_1_us/"+s);
            }
            if(asaetpos==1){
                stream=getAssets().open("level_2_us/"+s);
            }
            if(asaetpos==2){
                stream=getAssets().open("level_3_us/"+s);
            }
            if(asaetpos==3){
                stream=getAssets().open("level_4_us/"+s);
            }
            if(asaetpos==4){
                stream=getAssets().open("level_5_us/"+s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Drawable drawable=Drawable.createFromStream(stream,null);
        imageView.setImageDrawable(drawable);

    }
    public void init(){
        for(int i=0;i<14;i++){
            int id=getResources().getIdentifier("btn"+i,"id",getPackageName());
            btn[i]=findViewById(id);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}