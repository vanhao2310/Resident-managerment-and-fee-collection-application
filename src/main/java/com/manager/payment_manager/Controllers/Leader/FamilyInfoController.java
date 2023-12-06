package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.NhanKhau;
import com.manager.payment_manager.Services.NhanKhauService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FamilyInfoController implements Initializable {
    public AnchorPane add_member_btn;
    public Label chu_ho_lbl;
    public Label address_lbl;
    public Label id_ho_lbl;
    public VBox member_vbox;


    public void updateFamilyInfo(String id_ho) {
        System.out.println(id_ho);
        System.out.println(id_ho_lbl.getText());
        this.id_ho_lbl.setText(id_ho);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_member_btn.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) add_member_btn.getScene().getWindow();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/AddMember.fxml"));
                stage.setScene(new Scene(loader.load()));
                AddMemberController addMemberController = loader.getController();
                addMemberController.saveID(id_ho_lbl.getText());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        this.showListMember();
    }
    public void showListMember(){
        member_vbox.getChildren().clear();
        List<NhanKhau> dsNhanKhau = NhanKhauService.getNhanKhau(this.id_ho_lbl.getText());
        for(NhanKhau tmp : dsNhanKhau){
            System.out.println(tmp.toString());
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/MemberList.fxml"));
                Parent memberList = loader.load();
                MemberListController controller = loader.getController();
                controller.setInfo(tmp);
                controller.saveID(id_ho_lbl.getText());
                member_vbox.getChildren().add(memberList);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
