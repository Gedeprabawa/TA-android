package com.example.projectjaringan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

     //private String [] datamenu={"Router","LAN Card","WLAN Card","Access Point","Kabel Jaringan","Switch","HUB"}  ;
    private MenuAdapater adapter;
    private String[] datanama;
    private String[] datades;
    private String[] datapengertian;
    private String[] datafungsi;
    private String[] datacara_kerja;
    private String[] dataharga;
    private TypedArray datagambar;
    private ArrayList<Menu> menus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvlistjar= findViewById(R.id.lv_menu);
        adapter=new MenuAdapater(this);
        lvlistjar.setAdapter(adapter);

        prepare();
        tambahitem();

        lvlistjar.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                 Toast.makeText(MainActivity.this,menus.get(i).getNama(),Toast.LENGTH_SHORT).show();
                 Intent transferdata= new Intent(MainActivity.this,DetailActivity.class);
                 transferdata.putExtra(DetailActivity.tpgambar,menus.get(i).getGambar());
                 transferdata.putExtra(DetailActivity.tppengertian,menus.get(i).getPengertian());
                 transferdata.putExtra(DetailActivity.tpfungsi,menus.get(i).getFungsi());
                 transferdata.putExtra(DetailActivity.tpcarakerja,menus.get(i).getCara_kerja());
                 transferdata.putExtra(DetailActivity.tpharga,menus.get(i).getHarga());
                 startActivity(transferdata);

            }
        });
    }

    private void prepare(){
        datagambar=getResources().obtainTypedArray(R.array.data_gambar) ;
        datanama=getResources().getStringArray(R.array.data_menu) ;
        datades=getResources().getStringArray(R.array.data_des) ;
        datapengertian=getResources().getStringArray(R.array.data_pengertian) ;
        datafungsi=getResources().getStringArray(R.array.data_fungsi) ;
        datacara_kerja=getResources().getStringArray(R.array.cara_kerja) ;
        dataharga=getResources().getStringArray(R.array.harga) ;

    }

    private void tambahitem(){
        menus= new ArrayList<>();
        for (int i=0;i<datanama.length;i++){
            Menu menu =new Menu();
            menu.setGambar(datagambar.getResourceId(i, -1));
            menu.setNama(datanama[i]);
            menu.setDeskripsi(datades[i]);
            menu.setPengertian(datapengertian[i]);
            menu.setFungsi(datafungsi[i]);
            menu.setCara_kerja(datacara_kerja[i]);
            menu.setHarga(dataharga[i]);
            menus.add(menu);
        }
        adapter.setMenus(menus);
    }

}
