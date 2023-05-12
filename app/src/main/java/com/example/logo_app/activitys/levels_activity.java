package com.example.logo_app.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.logo_app.R;
import com.example.logo_app.adapters.level_adapter;

import java.util.ArrayList;

public class levels_activity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList levels= new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        levelfill();
        recyclerView=findViewById(R.id.recycler_levels);
        level_adapter  level_adapter= new level_adapter(levels_activity.this,levels);



        LinearLayoutManager manager= new LinearLayoutManager(levels_activity.this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(level_adapter);



    }
    public void levelfill(){
        levels.add("LEVEL 1");
        levels.add("LEVEL 2");
        levels.add("LEVEL 3");
        levels.add("LEVEL 4");
        levels.add("LEVEL 5");
//        levels.add("LEVEL 6");
//        levels.add("LEVEL 7");
//        levels.add("LEVEL 8");
//        levels.add("LEVEL 9");
//        levels.add("LEVEL 10");
//        levels.add("LEVEL 11");
//        levels.add("LEVEL 11");
//        levels.add("LEVEL 12");
//        levels.add("LEVEL 13");
//        levels.add("LEVEL 14");
//        levels.add("LEVEL 15");
//        levels.add("LEVEL 16");
//        levels.add("LEVEL 17");
//        levels.add("LEVEL 18");
//        levels.add("LEVEL 19");
//        levels.add("LEVEL 20");
//        levels.add("LEVEL 21");
//        levels.add("LEVEL 22");
//        levels.add("LEVEL 23");
//        levels.add("LEVEL 24");
//        levels.add("LEVEL 25");
//        levels.add("LEVEL 26");
    }
}