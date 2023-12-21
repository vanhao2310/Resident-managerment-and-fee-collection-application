package com.manager.payment_manager.Models;

public class HoKhau {
    private int idHo;
    private String chuHo;
    private String diaChi;
    private int soThanhVien;

    public HoKhau(int idHo, String chuHo, String diaChi, int soThanhVien) {
        this.idHo = idHo;
        this.chuHo = chuHo;
        this.diaChi = diaChi;
        this.soThanhVien = soThanhVien;
    }
    public int getIdHo() {
        return idHo;
    }

    public void setIdHo(int idHo) {
        this.idHo = idHo;
    }

    public String getChuHo() {
        return chuHo;
    }

    public void setChuHo(String chuHo) {
        this.chuHo = chuHo;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoThanhVien() {
        return soThanhVien;
    }

    public void setSoThanhVien(int soThanhVien) {
        this.soThanhVien = soThanhVien;
    }
}
