package com.example.logo_app.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.logo_app.R;
import com.example.logo_app.adapters.pager_view_adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class logo_play_activity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    Button btn[]= new Button[14];
    ViewPager  viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_play);
        int pos=getIntent().getIntExtra("imgpos",0);
        int asaetpos=getIntent().getIntExtra("asset",0);
        String s = getIntent().getStringExtra("list");

        viewPager=findViewById(R.id.viewPager);
        PagerAdapter pagerAdapter= new pager_view_adapter(logo_play_activity.this,pos,asaetpos,s);
        viewPager.setAdapter(pagerAdapter);







    }
    public void init(){
        for(int i=0;i<14;i++){
            int id=getResources().getIdentifier("btn"+i,"id",getPackageName());
            btn[i]=findViewById(id);
        }
    }
    public void charcter_maker(){
        String s = getIntent().getStringExtra("list");
        ArrayList<Character> arrayList= new ArrayList<>();
        String[] split= s.split("\\.");
        System.out.println("slit name :"+split[0]);
        char ans[]= new char[100];
        ans=split[0].toCharArray();

        for (int i = 0; i < ans.length; i++) {
            arrayList.add(ans[i]);
            System.out.println("ans=="+ans[i]);
        }
        for (int i=ans.length;i<14;i++){

            char rand= (char) (new Random().nextInt('z'-'a')+'a');
            arrayList.add(rand);
            System.out.println("random=="+arrayList.get(i));

        }
        Collections.shuffle(arrayList);
        for (int i = 0; i < btn.length; i++) {
            btn[i].setOnClickListener(this);
            btn[i].setText(""+arrayList.get(i));
        }
    }

    @Override
    public void onClick(View v) {

    }
}