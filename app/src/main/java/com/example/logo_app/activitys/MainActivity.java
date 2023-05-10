package com.example.logo_app.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.logo_app.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button trophy,play,leaderboard,statistic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        trophy=findViewById(R.id.main_trophy_btn);
        statistic=findViewById(R.id.main_statistic_btn);
        leaderboard=findViewById(R.id.main_trophy_btn);
        play=findViewById(R.id.main_play_btn);

        //on Click lisners
        trophy.setOnClickListener(this);
        statistic.setOnClickListener(this);
        leaderboard.setOnClickListener(this);
        play.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==play.getId()){

            Intent intent= new Intent(MainActivity.this, levels_activity.class);
            startActivity(intent);

        }
        if(v.getId()==trophy.getId()){


        }
        if(v.getId()==statistic.getId()){


        }
        if(v.getId()==leaderboard.getId()){


        }
    }
}