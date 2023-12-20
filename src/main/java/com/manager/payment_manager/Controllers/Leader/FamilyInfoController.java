package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Family;
import com.manager.payment_manager.Models.NhanKhau;
import com.manager.payment_manager.Services.FamilyService;
import com.manager.payment_manager.Services.NhanKhauService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
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
    public AnchorPane delete_member_btn;
    public Label chu_ho_lbl;
    public Label address_lbl;
    public Label id_ho_lbl;
    public VBox member_vbox;
    public Label dispart_btn;


    public void updateFamilyInfo(String id_ho) {
        // System.out.println("FamilyInfo: " + id_ho);
        this.id_ho_lbl.setText(id_ho);
        showListMember(id_ho);
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
        delete_member_btn.setOnMouseClicked(actionEvent -> {
            this.deleteMember();
        });

        dispart_btn.setOnMouseClicked(event -> {
            Stage stage = (Stage) add_member_btn.getScene().getWindow();
            List<Integer> listDispart = this.listDispartFamily();
            if(listDispart != null) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/AddFamily.fxml"));
                    stage.setScene(new Scene(loader.load()));
                    AddFamilyController addFamilyController = loader.getController();
                    addFamilyController.dispartFamily(listDispart, id_ho_lbl.getText());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }
    public void showListMember(String id_ho){
        member_vbox.getChildren().clear();
        List<NhanKhau> dsNhanKhau = NhanKhauService.getNhanKhau(id_ho);
        Family family = FamilyService.getFamilyWithID(id_ho);
        this.chu_ho_lbl.setText(family.getFamilyHead());
        this.address_lbl.setText(family.getFamilyAddress());

        for(NhanKhau tmp : dsNhanKhau){
            // System.out.println(tmp.toString());
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/MemberList.fxml"));
                Parent memberList = loader.load();
                MemberListController controller = loader.getController();
                controller.setInfo(tmp);
                controller.saveID(id_ho);
                memberList.setUserData(controller);
                member_vbox.getChildren().add(memberList);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
    public void deleteMember() {
        List<MemberListController> selectedMembers = new ArrayList<>();
        boolean hasCheckedMember = false;
        // Lặp qua tất cả các thành viên trong member_vbox và kiểm tra xem đã chọn delete_check_box chưa
        for (int i = 0; i < member_vbox.getChildren().size(); i++) {
            MemberListController controller = (MemberListController) member_vbox.getChildren().get(i).getUserData();
            if (controller != null && controller.isChecked()) {
                selectedMembers.add(controller);
                hasCheckedMember = true;
            }
        }

        if (!hasCheckedMember) {
            // Hiển thị thông báo không thể xóa vì chưa chọn checkbox
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Không thể xóa. Hãy chọn ít nhất một thành viên để xóa.");
            alert.showAndWait();
            return;
        }

        // Xóa các thành viên đã chọn khỏi cơ sở dữ liệu và giao diện
        for (MemberListController controller : selectedMembers) {
            String memberId = controller.id_lbl.getText();
            NhanKhauService.deleteNhanKhau(memberId); // Thực hiện xóa thành viên khỏi cơ sở dữ liệu
            member_vbox.getChildren().remove((Parent) controller.delete_check_box.getParent()); // Xóa thành viên khỏi giao diện
            updateFamilyInfo(id_ho_lbl.getText());
        }
    }

    public List<Integer> listDispartFamily(){
        List<MemberListController> selectedMembers = new ArrayList<>();
        boolean hasCheckedMember = false;
        // Lặp qua tất cả các thành viên trong member_vbox và kiểm tra xem đã chọn chưa
        for (int i = 0; i < member_vbox.getChildren().size(); i++) {
            MemberListController controller = (MemberListController) member_vbox.getChildren().get(i).getUserData();
            if (controller != null && controller.isChecked()) {
                selectedMembers.add(controller);
                hasCheckedMember = true;
            }
        }

        if (!hasCheckedMember) {
            // Hiển thị thông báo phải chọn ít nhất 1 người để tách hộ khác
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Không thể tách hộ. Hãy chọn ít nhất một thành viên để tách.");
            alert.showAndWait();
            return null;
        }
        List<Integer> listDispart = new ArrayList<>();
        for(MemberListController controller : selectedMembers) {
            String memberId = controller.id_lbl.getText();
            listDispart.add(Integer.parseInt(memberId));
        }
        return listDispart;
    }
}
