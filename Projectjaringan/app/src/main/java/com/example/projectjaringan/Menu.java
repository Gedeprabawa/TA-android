package com.example.projectjaringan;

public class Menu {

    private String nama;
    private String gambar;
    private String deskripsi;
    private String harga;
    private String fungsi;
    private String carakerja;

    public Menu( String datanama, String datagambar, String datadeskripsi, String dataharga, String datafungsi, String datacara){
        nama =datanama;
        gambar =datagambar;
        deskripsi =datadeskripsi;
        harga =dataharga;
        fungsi =datafungsi;
        carakerja =datacara;
    }

    public String getHarga() {
        return harga;
    }

    public String getFungsi() {
        return fungsi;
    }

    public String getCarakerja() {
        return carakerja;
    }

    public String getNama() {
        return nama;
    }

    public String getGambar() {
        return gambar;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}
