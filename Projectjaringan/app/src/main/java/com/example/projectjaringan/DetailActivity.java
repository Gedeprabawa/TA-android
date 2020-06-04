package com.example.projectjaringan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.example.projectjaringan.MainActivity.EXTRA_IMG;
import static com.example.projectjaringan.MainActivity.EXTRA_NAMA;
import static com.example.projectjaringan.MainActivity.EXTRA_DESKRIPSI;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent= getIntent();
        String foto= intent.getStringExtra(EXTRA_IMG);
        String nama= intent.getStringExtra(EXTRA_NAMA);
        String deskripsi= intent.getStringExtra(EXTRA_DESKRIPSI);

       ImageView ivgambar = findViewById(R.id.img_detail);
       TextView tvnama = findViewById(R.id.nama_detail);
       TextView tvdesk = findViewById(R.id.desk_detail);

        Glide
                .with(this)
                .load(foto)
                .into(ivgambar);

        tvnama.setText(nama);
        tvdesk.setText(deskripsi);

    }
}
