package com.example.projectjaringan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;


public class MenuAdapater extends RecyclerView.Adapter<MenuAdapater.MenuViewHolder> {

    private Context context;
    private ArrayList<Menu> menus;
    private  OnItemClickListener mClick;

    public interface OnItemClickListener{
        void onItemclick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mClick=listener;
    }

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
            Menu menubaru= menus.get(position);
            String gambarbaru= menubaru.getGambar();
            String nama= menubaru.getNama();
            String deskripsi= menubaru.getDeskripsi();

            holder.tvdatanama.setText(nama);
            holder.tvdatades.setText(deskripsi);
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
        public Button btninfo;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            ivdataimg =itemView.findViewById(R.id.img_menu);
            tvdatanama =itemView.findViewById(R.id.tv_nama);
            tvdatades =itemView.findViewById(R.id.tv_deskripsi);
            btninfo =itemView.findViewById(R.id.infodetail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mClick != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mClick.onItemclick(position);
                        }
                    }
                }
            });

        }
    }


}
