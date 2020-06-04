package com.example.projectjaringan;

public class Menu {

    private String gambar;
    private String nama;
    private String deskripsi;

    public Menu( String datanama, String datagambar, String datadeskripsi ){
        gambar = datagambar;
        nama = datanama;
        deskripsi = datadeskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}
