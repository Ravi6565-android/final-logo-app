package com.example.logo_app.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.logo_app.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class pager_view_adapter extends PagerAdapter  {

    Context context;
    Button btn[] = new Button[14],btnans[];

    int imgpos, level;
    ViewPager viewPager;
    ArrayList<String> image;
    String s;
    String[] split;
    ImageView imageView;
    LinearLayout layout;
    int cnt=1;
    private int counter=1;
    private int page=1;

    public pager_view_adapter(Context context, int imgpos, int level, ArrayList<String> image, ViewPager viewPager) {
        this.level = level;
        this.imgpos = imgpos;
        this.context = context;
        this.image = image;
        this.viewPager = viewPager;

    }


    @Override
    public int getCount() {
        return image.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.logo_play_item, container, false);
        layout = view.findViewById(R.id.linearplay);
        imageView = view.findViewById(R.id.play_image);

        Log.d("TTT", "Instanciate Called=="+(counter++)+"\t Page Position="+position);

        for (int i = 0; i < 14; i++) {
            int id = context.getResources().getIdentifier("btn" + i, "id", context.getPackageName());
            btn[i] = view.findViewById(id);
        }
        try {
            charmaker(position);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        imageset(position);







        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                try {
                    Log.d("TTT", "On Page Selectec Called=="+(page++)+"\t Page Position="+position);
                    charmaker(position);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                imageset(position);
                //button_thing();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        container.addView(view);
        return view;
        // return super.instantiateItem(container, position);


    }

    public void charmaker(int pos) throws IOException {
        ArrayList<Character> arrayList = new ArrayList<>();
        if (level == 0) {
            s = image.get(pos);
        }
        if (level == 1) {
            s = image.get(pos);
        }
        if (level == 2) {
            s = image.get(pos);
        }
        if (level == 3) {
            s = image.get(pos);
        }
        if (level == 4) {
            s = image.get(pos);
        }
        split = s.split("\\.");
        System.out.println("slit name :" + split[0]);
        char ans[] = new char[100];
        ans = split[0].toCharArray();

        for (int i = 0; i < ans.length; i++) {
            arrayList.add(ans[i]);
            System.out.println("ans==" + ans[i]);
        }
        for (int i = ans.length; i < 14; i++) {

            char rand = (char) (new Random().nextInt('z' - 'a') + 'a');
            arrayList.add(rand);
            System.out.println("random==" + arrayList.get(i));

        }


        System.out.println("====" + s);
        Collections.shuffle(arrayList);
        for (int i = 0; i < btn.length; i++) {
            btn[i].setText(""+arrayList.get(i));
        }




    }
    public void button_thing(){

        Button[] ansbtn = new Button[split[0].length()];

            layout.removeAllViews();

        System.out.println("s===="+split[0].length());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(5, 5, 5, 5);
        layoutParams.weight = 1;


        for (int i = 0; i < split[0].length(); i++) {
            ansbtn[i]= new Button(context);
            ansbtn[i].setLayoutParams(layoutParams);
            ansbtn[i].setBackgroundResource(R.color.purple_200);
            layout.addView(ansbtn[i]);
        }
        for (int i = 0; i < btn.length; i++) {
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int j = 0; j < btn.length; j++) {
                        if(v.getId()==btn[j].getId()){
                            ansbtn[cnt].setText(btn[j].getText().toString());
                            cnt++;

                        }
                    }

                }
            });

        }

        split[0]="";
    }

    public void imageset(int imgpos) {
        Log.d("TTT", "Function Called=="+(cnt++));
        InputStream stream = null;
        try {
            if (level == 0) {
                stream = context.getAssets().open("level_1_us/" + s);
            }
            if (level == 1) {
                stream = context.getAssets().open("level_2_us/" + s);
            }
            if (level == 2) {
                stream = context.getAssets().open("level_3_us/" + s);
            }
            if (level == 3) {
                stream = context.getAssets().open("level_4_us/" + s);
            }
            if (level == 4) {
                stream = context.getAssets().open("level_5_us/" + s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Drawable drawable = Drawable.createFromStream(stream, null);
        imageView.setImageDrawable(drawable);
        Button[] ansbtn = new Button[split[0].length()];

        layout.removeAllViews();

        System.out.println("s===="+split[0].length());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(5, 5, 5, 5);
        layoutParams.weight = 1;


        for (int i = 0; i < split[0].length(); i++) {
            ansbtn[i]= new Button(context);
            ansbtn[i].setLayoutParams(layoutParams);
            ansbtn[i].setBackgroundResource(R.color.purple_200);
            layout.addView(ansbtn[i]);
        }
        for (int i = 0; i < btn.length; i++) {
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int j = 0; j < btn.length; j++) {
                        if(v.getId()==btn[j].getId()){
                            ansbtn[cnt].setText(btn[j].getText().toString());
                            cnt++;

                        }
                    }

                }
            });

        }

        split[0]="";
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


}