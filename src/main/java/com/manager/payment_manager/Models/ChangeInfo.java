package com.manager.payment_manager.Models;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class ChangeInfo {

    private int id;
    private int loai;
    private String ten_loai;
    private int ID_nguoi;
    private String ghi_chu;
    private String noi_den;
    private Date ngay_thay_doi;
    private Date ngay_ket_thuc;

    public ChangeInfo(int id, String ten_loai, Date ngay_thay_doi) {
        this.id = id;
        this.ten_loai = ten_loai;
        this.ngay_thay_doi = ngay_thay_doi;
    }

    public ChangeInfo(int loai, String ten_loai, int ID_nguoi, String ghi_chu, Date ngay_thay_doi) {
        this.loai = loai;
        this.ten_loai = ten_loai;
        this.ID_nguoi = ID_nguoi;
        this.ghi_chu = ghi_chu;
        this.ngay_thay_doi = ngay_thay_doi;
    }

    public ChangeInfo(int id, int loai, String ten_loai, int ID_nguoi, String ghi_chu, Date ngay_thay_doi) {
        this.id = id;
        this.loai = loai;
        this.ten_loai = ten_loai;
        this.ID_nguoi = ID_nguoi;
        this.ghi_chu = ghi_chu;
        this.ngay_thay_doi = ngay_thay_doi;
    }

//    public ChangeInfo(int loai, String ten_loai, String ghi_chu, Date ngay_thay_doi) {
//        this.loai = loai;
//        this.ten_loai = ten_loai;
//        this.ghi_chu = ghi_chu;
//        this.ngay_thay_doi = ngay_thay_doi;
//    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getLoai() {
        return loai;
    }
    public void setLoai(int loai) {
        this.loai = loai;
    }
    public String getTen_loai() {
        return ten_loai;
    }
    public void setTen_loai(String ten_loai) {
        this.ten_loai = ten_loai;
    }
    public int getID_nguoi() {
        return ID_nguoi;
    }
    public void setID_nguoi(int ID_nguoi) {
        this.ID_nguoi = ID_nguoi;
    }
    public String getGhi_chu() {
        return ghi_chu;
    }
    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }
    public String getNoi_den() {
        return noi_den;
    }
    public void setNoi_den(String noi_den) {
        this.noi_den = noi_den;
    }
    public java.sql.Date getNgay_thay_doi() {
        return (java.sql.Date) ngay_thay_doi;
    }
    public void setNgay_thay_doi(Date ngay_thay_doi) {
        this.ngay_thay_doi = ngay_thay_doi;
    }
    public Date getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }
    public void setNgay_ket_thuc(Date ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }


}
