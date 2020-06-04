package com.example.projectjaringan;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;


public class MenuAdapater extends RecyclerView.Adapter<MenuAdapater.MenuViewHolder> {

    private Context context;
    private ArrayList<Menu> menus;
    public MenuAdapater(Context mcontext, ArrayList<Menu> menujar){
        context= mcontext;
        menus= menujar;

    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_menu,parent,false);

        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menu menubaru = menus.get(position);
        String  gambarbaru = menubaru.getGambar();
        String namabaru = menubaru.getNama();
        String deskripsibaru = menubaru.getDeskripsi();

        holder.tvdatanama.setText(namabaru);
        holder.tvdatades.setText(deskripsibaru);
        Glide
                .with(context)
                .load(gambarbaru)
                .centerCrop()
                .into(holder.ivdataimg);
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivdataimg;
        public TextView tvdatanama;
        public TextView tvdatades;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            ivdataimg = itemView.findViewById(R.id.imgmenu);
            tvdatanama = itemView.findViewById(R.id.tvmenu);
            tvdatades = itemView.findViewById(R.id.tvdeskripsi);


        }
    }


}
