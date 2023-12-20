package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.ChangeInfo;
import com.manager.payment_manager.Models.Family;
import com.manager.payment_manager.Models.Model;
import com.manager.payment_manager.Services.ChangeInfoService;
import com.manager.payment_manager.Services.FamilyService;
import com.manager.payment_manager.Services.NhanKhauService;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddFamilyController implements Initializable {
    public TextField owner_name_lbl; // tên chủ hộ
    public TextField house_num_lbl; // số nhà
    public TextField street_lbl; // tên đường
    public TextField town_lbl; // phường / xã / thị trấn
    public TextField city_lbl; // thành phố
    public Label warning_label;
    public AnchorPane back_btn;
    public Button add_done_btn;
    public Button add_cancel_btn;
    public Label lbl_todo;

    private List<Integer> listDispart;
    private String idHo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.lbl_todo.setText("Thêm hộ khẩu");
        this.warning_label.setText("Vui lòng điền đầy đủ thông tin");
        warning_label.setVisible(false);

        back_btn.setOnMouseClicked(mouseEvent -> {
            this.clear_input();
            if(listDispart == null || listDispart.isEmpty()) {
                Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Managing");
            } else {
                this.listDispart.clear();
                this.getBackToFamilyInfo();
            }
        });

        add_done_btn.setOnAction(actionEvent -> {
            if (validation_check()) {
                // save family
                String address = "Số " + house_num_lbl.getText() + ", Phố " + street_lbl.getText() + ", Phường " +  town_lbl.getText() + ", Quận " + city_lbl.getText() + ", Thành Phố Hà Nội";
                Family newFamily = new Family(this.owner_name_lbl.getText(), address, 0);
                if(listDispart != null && !listDispart.isEmpty()) {
                    if(checkInListDispart(owner_name_lbl.getText())){
                        newFamily.setNumOfPeople(listDispart.size());
                        FamilyService.addFamily(newFamily);
                        int newIdHo = FamilyService.getIdHo(owner_name_lbl.getText(), address);
                        NhanKhauService.dispartFamily(listDispart, newIdHo);
                        List<ChangeInfo> listChange = new ArrayList<>();
                        for (Integer id : listDispart) {
                            listChange.add(new ChangeInfo(5, "Thay đổi hộ", id, "Tách hộ", Date.valueOf(LocalDate.now())));
                        }
                        ChangeInfoService.addChangeInfor(listChange);
                        this.clear_input();
                        this.listDispart.clear();
                        Model.getInstance().getViewFactory().updateListFamily();
                        // Model.getInstance().getViewFactory().updateChangeList();
                        this.getBackToFamilyInfo();
                    }else{
                        warning_label.setText("Tên chủ hộ không có trong danh sách cần tách");
                        warning_label.setVisible(true);
                    }
                }else{
                    FamilyService.addFamily(newFamily);this.clear_input();
                    //ChangeInfoService.addChangeInfor(new ChangeInfo(6, "Thêm hộ mới","Hộ mới",  java.sql.Date.valueOf(LocalDate.now())));
                    // back to managing
                    Model.getInstance().getViewFactory().updateListFamily();
                    Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Managing");
                }
            } else {
                warning_label.setVisible(true);
            }
        });

        add_cancel_btn.setOnAction(actionEvent -> {
            // clear data
            clear_input();
            warning_label.setVisible(false);
            if(listDispart != null && !listDispart.isEmpty()) {
                this.listDispart.clear();
                this.getBackToFamilyInfo();
            }
            // back to managing
            Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Managing");
        });
    }

    private boolean validation_check() {
        if (owner_name_lbl.getText().isEmpty()) return false;
        if (house_num_lbl.getText().isEmpty()) return false;
        if (street_lbl.getText().isEmpty()) return false;
        if (town_lbl.getText().isEmpty()) return false;
        return !city_lbl.getText().isEmpty();
    }

    private void clear_input() {
        owner_name_lbl.clear();
        house_num_lbl.clear();
        street_lbl.clear();
        town_lbl.clear();
        city_lbl.clear();
    }

    public void dispartFamily(List<Integer> members, String idHo) {
        this.lbl_todo.setText("Điền thông tin hộ khẩu mới");
        this.listDispart = members;
        this.idHo = idHo;
    }

    private void getBackToFamilyInfo() {
        Stage stage = (Stage) back_btn.getScene().getWindow();
        stage.close();
        Model.getInstance().getViewFactory().showFamilyDetail();
        Model.getInstance().getViewFactory().updateFamilyDetail(this.idHo);
    }

    private boolean checkInListDispart(String nameOwner) {
        List<Integer> idOwner = NhanKhauService.findByName(nameOwner);
        for(int id : idOwner) {
            if(listDispart.contains(id)) return true;
        }
        return false;
    }
}
