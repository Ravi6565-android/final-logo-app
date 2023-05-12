package com.example.logo_app.adapters;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logo_app.R;
import com.example.logo_app.activitys.logo_show_activity;


import java.util.ArrayList;

public class level_adapter extends RecyclerView.Adapter<level_adapter.userholder> {
    Context context;



    ArrayList<String> levels;
    public level_adapter(Context context, ArrayList levels) {
        this.context=context;
        this.levels=levels;

    }

    @NonNull
    @Override
    public level_adapter.userholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_levels_item,parent,false);
        userholder userholder=new userholder(view);

        return userholder;
    }

    @Override
    public void onBindViewHolder(@NonNull level_adapter.userholder holder, int position) {
        holder.imageView.setImageResource(R.drawable.playbutton);
        holder.textView.setText(levels.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,logo_show_activity.class);
                intent.putExtra("pos", holder.getAdapterPosition());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return levels.size();
    }

    public class userholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public userholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.recycler_item_imageview);
            textView=itemView.findViewById(R.id.recycler_item_text);

        }
    }
}
