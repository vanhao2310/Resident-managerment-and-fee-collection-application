package com.manager.payment_manager.Models;

import java.util.Date;

public class NhanKhau {
    private String id;
    private int idHo;
    private String hoTen;
    private String biDanh;
    private Date ngaySinh;
    private String gioiTinh;
    private String vaiTro;
    private String noiSinh;
    private String nguyenQuan;
    private String danToc;
    private String ngheNghiep;
    private String noiLamViec;
    private String CCCD;
    private Date ngayCap;
    private String noiCap;
    private Date ngayDangKiThuongTru;
    private String diaChiTruoc;
    private String trangThai;

    public NhanKhau(String id ,String hoTen, String biDanh, Date ngaySinh,
                    String noiSinh, String nguyenQuan, String danToc, String ngheNghiep, String noiLamViec,
                    String CCCD, Date ngayCap, String noiCap, Date ngayDangKiThuongTru, String diaChiTruoc) {
        this.id = id;
        this.hoTen = hoTen;
        this.biDanh = biDanh;
        this.ngaySinh = ngaySinh;
        this.noiSinh = noiSinh;
        this.nguyenQuan = nguyenQuan;
        this.danToc = danToc;
        this.ngheNghiep = ngheNghiep;
        this.noiLamViec = noiLamViec;
        this.CCCD = CCCD;
        this.ngayCap = ngayCap;
        this.noiCap = noiCap;
        this.ngayDangKiThuongTru = ngayDangKiThuongTru;
        this.diaChiTruoc = diaChiTruoc;
    }

    public NhanKhau(int id ,String hoTen, String biDanh, Date ngaySinh, String gioiTinh, String vaiTro,
                    String noiSinh, String nguyenQuan, String danToc, String ngheNghiep, String noiLamViec,
                    String CCCD, Date ngayCap, String noiCap, Date ngayDangKiThuongTru, String diaChiTruoc, int idHo) {
        this.id = String.valueOf(id);
        this.hoTen = hoTen;
        this.biDanh = biDanh;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.vaiTro = vaiTro;
        this.noiSinh = noiSinh;
        this.nguyenQuan = nguyenQuan;
        this.danToc = danToc;
        this.ngheNghiep = ngheNghiep;
        this.noiLamViec = noiLamViec;
        this.CCCD = CCCD;
        this.ngayCap = ngayCap;
        this.noiCap = noiCap;
        this.ngayDangKiThuongTru = ngayDangKiThuongTru;
        this.diaChiTruoc = diaChiTruoc;
        this.idHo = idHo;
    }

    public NhanKhau(int idHo, String hoTen, String biDanh, Date ngaySinh, String gioiTinh, String noiSinh,
                    String nguyenQuan, String danToc, String ngheNghiep, String noiLamViec, String CCCD, Date ngayCap,
                    String noiCap, Date ngayDangKiThuongTru, String diaChiTruoc) {
        this.idHo = idHo;
        this.hoTen = hoTen;
        this.biDanh = biDanh;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.noiSinh = noiSinh;
        this.nguyenQuan = nguyenQuan;
        this.danToc = danToc;
        this.ngheNghiep = ngheNghiep;
        this.noiLamViec = noiLamViec;
        this.CCCD = CCCD;
        this.ngayCap = ngayCap;
        this.noiCap = noiCap;
        this.ngayDangKiThuongTru = ngayDangKiThuongTru;
        this.diaChiTruoc = diaChiTruoc;
    }

    public NhanKhau(int idHo, String hoTen, String biDanh, Date ngaySinh, String gioiTinh, String noiSinh,
                    String nguyenQuan, String danToc, String ngheNghiep, String noiLamViec, String CCCD, Date ngayCap,
                    String noiCap, Date ngayDangKiThuongTru, String diaChiTruoc, int ID_HO) {
        this.idHo = idHo;
        this.hoTen = hoTen;
        this.biDanh = biDanh;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.noiSinh = noiSinh;
        this.nguyenQuan = nguyenQuan;
        this.danToc = danToc;
        this.ngheNghiep = ngheNghiep;
        this.noiLamViec = noiLamViec;
        this.CCCD = CCCD;
        this.ngayCap = ngayCap;
        this.noiCap = noiCap;
        this.ngayDangKiThuongTru = ngayDangKiThuongTru;
        this.diaChiTruoc = diaChiTruoc;
        this.idHo = ID_HO;
    }



    @Override
    public String toString (){
        return this.id + " " + this.hoTen + " " + this.CCCD + " " + this.ngaySinh;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public void setBiDanh(String biDanh) {
        this.biDanh = biDanh;
    }
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }
    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }
    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }
    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }
    public void setNoiLamViec(String noiLamViec) {
        this.noiLamViec = noiLamViec;
    }
    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }
    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }
    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
    }
    public void setNgayDangKiThuongTru(Date ngayDangKiThuongTru) {
        this.ngayDangKiThuongTru = ngayDangKiThuongTru;
    }
    public void setDiaChiTruoc(String diaChiTruoc) {
        this.diaChiTruoc = diaChiTruoc;
    }
    public String getHoTen() {
        return hoTen;
    }
    public String getBiDanh() {
        return biDanh;
    }
    public java.sql.Date getNgaySinh() {
        return (java.sql.Date) this.ngaySinh;
    }
    public String getNoiSinh() {
        return noiSinh;
    }
    public String getNguyenQuan() {
        return nguyenQuan;
    }
    public String getDanToc() {
        return danToc;
    }
    public String getNgheNghiep() {
        return ngheNghiep;
    }
    public String getNoiLamViec() {
        return noiLamViec;
    }
    public String getCCCD() {
        return CCCD;
    }
    public java.sql.Date getNgayCap() {
        return (java.sql.Date) ngayCap;
    }
    public String getNoiCap() {
        return noiCap;
    }
    public Date getNgayDangKiThuongTru() {
        return ngayDangKiThuongTru;
    }
    public String getDiaChiTruoc() {
        return diaChiTruoc;
    }
    public String getId() {
        return id;
    }
    public int getIdHo(){
        return this.idHo;
    }
    public String getGioiTinh(){
        return this.gioiTinh;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setIdHo(int idHo) {
        this.idHo = idHo;
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public String getVaiTro() {
        return vaiTro;
    }
    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

}
