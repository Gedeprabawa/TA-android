package com.example.projectjaringan;

public class Menu {

    private int gambar;
    private String nama;
    private String deskripsi;

    public Menu(int datagambar, String datanama,String datadeskripsi){
        gambar = datagambar;
        nama = datanama;
        deskripsi = datadeskripsi;
    }

    public int getGambar() {
        return gambar;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}
