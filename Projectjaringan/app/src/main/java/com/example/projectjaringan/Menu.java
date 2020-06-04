package com.example.projectjaringan;

public class Menu {

    private String nama;
    private String gambar;
    private String deskripsi;

    public Menu( String datanama, String datagambar, String datadeskripsi){
        nama =datanama;
        gambar =datagambar;
        deskripsi =datadeskripsi;
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
