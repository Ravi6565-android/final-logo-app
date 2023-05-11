package com.example.logo_app.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.logo_app.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class grid_adapter extends BaseAdapter {

    List<String> image;
    Context context;
    int pos;
    public grid_adapter(Context context , List<String> image, int pos) {
        this.context=context;
        this.image=image;
        this.pos=pos;
    }

    @Override
    public int getCount() {
        return image.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(R.layout.logo_show_grid_items,parent,false);
        ImageView imageView=convertView.findViewById(R.id.logo_show_grid_item_image);
        InputStream stream=null;

        try {
            if(pos==2){
                stream=context.getAssets().open("solved/"+image.get(position));
            } if(pos==4){
                stream=context.getAssets().open("unsolved/"+image.get(position));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Drawable drawable=Drawable.createFromStream(stream,null);
        imageView.setImageDrawable(drawable);
        return convertView;
    }
}
