package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.ChangeInfo;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangeListController implements Initializable {
    public Label id_lbl;
    public Label ten_loai_lbl;
    public Label ngay_thay_doi_lbl;
    public Hyperlink detail_btn;
    public CheckBox check_box;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void updateInfo(ChangeInfo ci) {
        id_lbl.setText(String.valueOf(ci.getId()));
        ten_loai_lbl.setText(ci.getTen_loai());
        ngay_thay_doi_lbl.setText(ci.getNgay_thay_doi().toString());
    }
}
