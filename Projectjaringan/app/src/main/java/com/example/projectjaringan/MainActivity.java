package com.example.projectjaringan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MenuAdapater.OnItemClickListener {
    public static final String EXTRA_IMG = "gambar";
    public static final String EXTRA_NAMA = "nama";
    public static final String EXTRA_DESKRIPSI = "deskripsi";
    public static final String EXTRA_HARGA = "harga";
    public static final String EXTRA_FUNGSI = "fungsi";
    public static final String EXTRA_CARA = "cara_kerja";

    private MenuAdapater menuAdapater;
    private RecyclerView recyclerView;
    private ArrayList<Menu> menus;
    int jumdata;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        menus= new ArrayList<>();
        requestQueue= Volley.newRequestQueue(this);
        parseJSON ();

    }

    private void parseJSON() {
        String urlweb ="https://tudeastha.000webhostapp.com/koneksi.php";
        JsonArrayRequest request =new JsonArrayRequest(Request.Method.GET, urlweb, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        jumdata =response.length();
                        try {
                            for (int i = 0; i < jumdata; i++) {
                                JSONObject data =response.getJSONObject(i);
                                String gambarmenu =data.getString("gambar");
                                String namamenu =data.getString("nama");
                                String deksripsimenu =data.getString("deskripsi");
                                String harga =data.getString("harga");
                                String fungsi =data.getString("fungsi");
                                String caraker =data.getString("cara_kerja");
                                menus.add(new Menu( namamenu,  gambarmenu, deksripsimenu, harga, fungsi, caraker));
                            }
                            menuAdapater =new MenuAdapater(MainActivity.this, menus);
                            recyclerView.setAdapter(menuAdapater);

                            menuAdapater.setOnItemClickListener(MainActivity.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
    });
         requestQueue.add(request);
    }

    @Override
    public void onItemclick(int position) {
        Intent intentdetail = new Intent(this, DetailActivity.class);
        Menu clickitem = menus.get(position);
        intentdetail.putExtra(EXTRA_IMG, clickitem.getGambar());
        intentdetail.putExtra(EXTRA_NAMA, clickitem.getNama());
        intentdetail.putExtra(EXTRA_DESKRIPSI, clickitem.getDeskripsi());
        intentdetail.putExtra(EXTRA_HARGA, clickitem.getHarga());
        intentdetail.putExtra(EXTRA_FUNGSI, clickitem.getFungsi());
        intentdetail.putExtra(EXTRA_CARA, clickitem.getCarakerja());

        startActivity(intentdetail);
    }
}

