package com.example.logo_app.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.logo_app.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class pager_view_adapter extends PagerAdapter implements View.OnClickListener {

Context context;
int pos,assetpos;
    ArrayList<String> image;
    String s;
    public pager_view_adapter(Context context, int pos, int assetpos, String s, ArrayList<String> image) {
    this.assetpos=assetpos;
    this.pos=pos;
    this.context=context;
    this.s=s;
    this.image=image;

    }


    @Override
    public int getCount() {
        return image.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view= LayoutInflater.from(context).inflate(R.layout.logo_play_item,container,false);
        ImageView imageView;
        imageView=view.findViewById(R.id.play_image);
        Button btn[]= new Button[14];
        for(int i=0;i<14;i++){
            int id=context.getResources().getIdentifier("btn"+i,"id",context.getPackageName());
            btn[i]=view.findViewById(id);
        }

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
        System.out.println("===="+s);
        Collections.shuffle(arrayList);
        for (int i = 0; i < btn.length; i++) {
            btn[i].setOnClickListener(this);
            btn[i].setText(""+arrayList.get(i));
        }
        InputStream stream=null;
        try {
            if(assetpos==0){
                stream=context.getAssets().open("level_1_us/"+s);
            }
            if(assetpos==1){
                stream=context.getAssets().open("level_2_us/"+s);
            }
            if(assetpos==2){
                stream=context.getAssets().open("level_3_us/"+s);
            }
            if(assetpos==3){
                stream=context.getAssets().open("level_4_us/"+s);
            }
            if(assetpos==4){
                stream=context.getAssets().open("level_5_us/"+s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Drawable drawable=Drawable.createFromStream(stream,null);
        imageView.setImageDrawable(drawable);
        container.addView(view);
        return container;
       // return super.instantiateItem(container, position);


    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public void onClick(View view) {

    }
}
