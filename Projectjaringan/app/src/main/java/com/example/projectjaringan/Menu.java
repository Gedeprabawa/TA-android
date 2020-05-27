package com.example.projectjaringan;

class Menu {
    private int gambar;
    private String nama;
    private String Deskripsi;
    private String pengertian;
    private String fungsi;
    private String cara_kerja;
    private String harga;

    Menu() {
    }
    public int getGambar() { return gambar; }
    public void setGambar(int gambar) { this.gambar = gambar; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getDeskripsi() { return Deskripsi; }
    public void setDeskripsi(String deskripsi) { Deskripsi = deskripsi; }
    public String getPengertian() { return pengertian; }
    public void setPengertian (String pengertian) { this.pengertian = pengertian; }
    public String getFungsi() { return fungsi; }
    public void setFungsi(String fungsi) {this.fungsi= fungsi; }
    public String getCara_kerja() { return cara_kerja; }
    public void setCara_kerja(String cara_kerja) { this.cara_kerja = cara_kerja; }
    public String getHarga() { return harga; }
    public void setHarga(String harga) { this.harga = harga; }
}
