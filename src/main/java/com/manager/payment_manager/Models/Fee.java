package com.manager.payment_manager.Models;

import java.util.Date;
public class Fee {
    private int id;
    private int fee_type;
    private String fee_name;
    private int don_gia;
    private Date ngay_bat_dau;
    private Date ngay_ket_thuc;

    public Fee (int id, int fee_type, String fee_name) {
        this.id = id;
        this.fee_type = fee_type;
        this.fee_name = fee_name;
    }

    public Fee(int fee_type, String fee_name, int don_gia, Date ngay_bat_dau, Date ngay_ket_thuc){
        this.fee_type = fee_type;
        this.fee_name = fee_name;
        this.don_gia = don_gia;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getFee_type() {
        return fee_type;
    }
    public void setFee_type(int fee_type) {
        this.fee_type = fee_type;
    }
    public String getFee_name() {
        return fee_name;
    }
    public void setFee_name(String fee_name) {
        this.fee_name = fee_name;
    }
    public void setDon_gia(int don_gia){this.don_gia = don_gia;}
    public int getDon_gia(){return don_gia;}
    public void setNgay_bat_dau(Date ngay_bat_dau){this.ngay_bat_dau = ngay_bat_dau;}
    public java.sql.Date getNgay_bat_dau(){return (java.sql.Date) this.ngay_bat_dau;}
    public void setNgay_ket_thuc(Date ngay_ket_thuc){this.ngay_ket_thuc = ngay_ket_thuc;}
    public java.sql.Date getNgay_ket_thuc(){return (java.sql.Date) this.ngay_ket_thuc;}
}
