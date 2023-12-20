package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Services.NhanKhauService;
import javafx.scene.control.Label;

public class ChangeDetailController {
    public Label name_lbl;
    public Label type_lbl;
    public Label change_date_lbl;
    public Label note_lbl;
    public Label id_ho_lbl;

    public void updateInfo(int id_nguoi, int id_ho, String ten_loai, String change_date, String note) {
        // System.out.println("ID_NGUOI: " + id_nguoi);
        name_lbl.setText(NhanKhauService.getThongTinNhanKhau(String.valueOf(id_nguoi)).getHoTen());
        type_lbl.setText(ten_loai);
        change_date_lbl.setText(change_date);
        note_lbl.setText(note);
        id_ho_lbl.setText(String.valueOf(id_ho));
    }
}
