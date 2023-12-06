package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.NhanKhau;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MemberListController implements Initializable {


    public Label id_lbl;
    public Label name_lbl;
    public Label cccd_lbl;
    public Label job_lbl;
    public Hyperlink detail_lbl;
    public CheckBox delete_check_box;

    public void setInfor(NhanKhau nhankhau){
        this.id_lbl.setText(nhankhau.getId());
        this.name_lbl.setText(nhankhau.getHoTen());
        this.cccd_lbl.setText(nhankhau.getCCCD());
        this.job_lbl.setText(nhankhau.getNgheNghiep());
    }

    public  boolean isChecked(){
        return this.delete_check_box.isSelected();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        detail_lbl.setOnAction(actionEvent -> {

        });
    }
}
