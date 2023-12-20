package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.NhanKhau;
import com.manager.payment_manager.Services.NhanKhauService;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MemberListController implements Initializable {
    private String id_ho;
    public Label id_lbl;
    public Label name_lbl;
    public Label cccd_lbl;
    public Hyperlink detail_lbl;
    public CheckBox delete_check_box;

    public void setInfo(NhanKhau nhankhau){
        this.id_lbl.setText(nhankhau.getId());
        this.name_lbl.setText(nhankhau.getHoTen());
        this.cccd_lbl.setText(nhankhau.getCCCD());
    }

    public  boolean isChecked(){
        return this.delete_check_box.isSelected();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        detail_lbl.setOnAction(actionEvent -> {
            Stage stage = (Stage) detail_lbl.getScene().getWindow();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/EditMember.fxml"));
                stage.setScene(new Scene(loader.load()));
                EditMemberController editMemberController = loader.getController();
                editMemberController.saveID(this.id_ho, id_lbl.getText());
                editMemberController.fillOldInfo(NhanKhauService.getThongTinNhanKhau(id_lbl.getText()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }

    public void saveID(String id_ho) {
        this.id_ho = id_ho;
    }
}
