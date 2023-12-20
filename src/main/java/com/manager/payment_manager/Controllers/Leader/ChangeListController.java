package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.ChangeInfo;
import com.manager.payment_manager.Models.Model;
import com.manager.payment_manager.Services.NhanKhauService;
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

    private int id_nguoi;
    private String note;
    private int id_ho;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        detail_btn.setOnMouseClicked(mouseEvent -> {
            Model.getInstance().getViewFactory().showChangeDetail();
            Model.getInstance().getViewFactory().updateChangeDetail(id_nguoi, id_ho, ten_loai_lbl.getText(), ngay_thay_doi_lbl.getText(), note);
        });

    }

    public void updateInfo(ChangeInfo ci) {
        id_lbl.setText(String.valueOf(ci.getId()));
        ten_loai_lbl.setText(ci.getTen_loai());
        ngay_thay_doi_lbl.setText(ci.getNgay_thay_doi().toString());

        this.note = ci.getGhi_chu();
        this.id_nguoi = ci.getID_nguoi();
        // System.out.println("save id: " + this.id_nguoi);
        this.id_ho = NhanKhauService.getThongTinNhanKhau(String.valueOf(id_nguoi)).getIdHo();
    }
}
