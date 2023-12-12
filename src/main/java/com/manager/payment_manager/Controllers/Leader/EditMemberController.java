package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Model;
import com.manager.payment_manager.Models.NhanKhau;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditMemberController implements Initializable {
    private String id_ho;
    public ComboBox status_combo_box;
    public AnchorPane back_btn;
    public TextField full_name_field;
    public TextField nick_name_field;
    public DatePicker birth_date_picker;
    public TextField born_field;
    public TextField nation_field;
    public TextField native_field;
    public TextField job_field;
    public TextField work_place_field;
    public TextField id_field;
    public DatePicker create_date_picker;
    public TextField create_place_field;
    public DatePicker sign_up_date_picker;
    public TextField prev_address_field;
    public Label warning_label;

    public Button edit_done_btn;
    public Button edit_cancel_btn;


    public void fillOldInfo(NhanKhau n) {
        full_name_field.setText(n.getHoTen());
        nick_name_field.setText(n.getBiDanh());
        born_field.setText(n.getNoiSinh());
        nation_field.setText(n.getNguyenQuan());
        native_field.setText(n.getDanToc());
        job_field.setText(n.getNgheNghiep());
        work_place_field.setText(n.getNoiLamViec());
        id_field.setText(n.getCCCD());
        create_place_field.setText(n.getNoiCap());
        prev_address_field.setText(n.getDiaChiTruoc());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setCombobox();
        warning_label.setVisible(false);
        back_btn.setOnMouseClicked(mouseEvent -> this.getBackToFamilyInfo());
        edit_cancel_btn.setOnMouseClicked(mouseEvent -> this.getBackToFamilyInfo());
        edit_done_btn.setOnMouseClicked(mouseEvent -> {
            // TODO: UPDATE INFORMATION
        });
    }

    public void saveID(String id_ho) {
        this.id_ho = id_ho;
        System.out.println("saved id");
    }

    private void getBackToFamilyInfo() {
        Stage stage = (Stage) back_btn.getScene().getWindow();
        stage.close();
        Model.getInstance().getViewFactory().showFamilyDetail();
        Model.getInstance().getViewFactory().updateFamilyDetail(this.id_ho);
    }

    private void setCombobox() {
        status_combo_box.getItems().add("Thường trú");
        status_combo_box.getItems().add("Tạm trú");
        status_combo_box.getItems().add("Tạm vắng");
    }
}
