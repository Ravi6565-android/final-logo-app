package com.example.logo_app.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.logo_app.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class logo_play_activity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_play);
        imageView=findViewById(R.id.play_image);
       List<String> image= Arrays.asList(getIntent().getStringArrayExtra("image"));
       int pos=getIntent().getIntExtra("asset",0);

        InputStream stream=null;
        try {
            stream=getAssets().open("level_1_us/", Integer.parseInt(image.get(pos)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Drawable drawable=Drawable.createFromStream(stream,null);
        imageView.setImageDrawable(drawable);

    }
}