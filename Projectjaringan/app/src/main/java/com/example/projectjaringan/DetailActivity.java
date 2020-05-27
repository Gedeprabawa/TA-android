package com.example.projectjaringan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String tpgambar="tpgambar";
    public static final String tppengertian="tppengertian";
    public static final String tpfungsi="tpfunsgi";
    public static final String tpcarakerja="tpcarakerja";
    public static final String tpharga="tpharga";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imgdetail=findViewById(R.id.img_detail);
        TextView tvpengertian=findViewById(R.id.tv_pengertian);
        TextView tvfungsi=findViewById(R.id.tv_fungsi);
        TextView tvcarakerja=findViewById(R.id.tv_carakerja);
        TextView tvharga=findViewById(R.id.tv_harga);

        imgdetail.setImageResource(getIntent().getIntExtra(tpgambar,0));
        tvpengertian.setText(getIntent().getStringExtra(tppengertian));
        tvfungsi.setText(getIntent().getStringExtra(tpfungsi));
        tvcarakerja.setText(getIntent().getStringExtra(tpcarakerja));
        tvharga.setText(getIntent().getStringExtra(tpharga));


    }
}
