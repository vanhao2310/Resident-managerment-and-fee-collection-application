package com.manager.payment_manager.Models;

import java.util.Date;

public class FeeLog {
    private int hoId;
    private int khoanThuId;
    private int soTien;
    private int dotNop;
    private Date ngayNop;

    public FeeLog(int hoId, int khoanThuId, int soTien, int dotNop, Date ngayNop) {
        this.hoId = hoId;
        this.khoanThuId = khoanThuId;
        this.soTien = soTien;
        this.dotNop = dotNop;
        this.ngayNop = ngayNop;
    }

    // Getters and setters
    public int getHoId() {
        return hoId;
    }

    public void setHoId(int hoId) {
        this.hoId = hoId;
    }

    public int getKhoanThuId() {
        return khoanThuId;
    }

    public void setKhoanThuId(int khoanThuId) {
        this.khoanThuId = khoanThuId;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public int getDotNop() {
        return dotNop;
    }

    public void setDotNop(int dotNop) {
        this.dotNop = dotNop;
    }

    public java.sql.Date getNgayNop() { return (java.sql.Date) this.ngayNop; }

    public void setNgayNop(Date ngayNop) {
        this.ngayNop = ngayNop;
    }
}
