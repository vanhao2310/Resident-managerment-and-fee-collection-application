package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.ChangeInfo;
import com.manager.payment_manager.Models.Model;
import com.manager.payment_manager.Models.NhanKhau;
import com.manager.payment_manager.Services.ChangeInfoService;
import com.manager.payment_manager.Services.NhanKhauService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddMemberController implements Initializable {
    @FXML
    public Button add_done_btn;
    @FXML
    public Button add_cancel_btn;
    public ComboBox<String> gender_combobox;
    private String id_ho;

    // DATA INPUT
    /* TODO: INPUT INFO
    * full_name_field - Họ và tên
    * nick_name_field - Bí danh
    * DATE birth_date_picker - ngày sinh
    * born_field - nơi sinh
    * native_field - nguyên quán
    * nation_field - dân tộc
    * job_field - nghề nghiệp
    * work_place_field - nơi làm việc
    * id_field - số CMND/CCCD
    * create_place_field - nơi cấp CMND/CCCD
    * DATE create_date_picker - ngày cấp
    * DATE sign_up_date_picker - ngày đăng ký thường trú
    * prev_address_field - địa chỉ thường trú trước khi chuyển đến
    * */
    public TextField full_name_field, nick_name_field, born_field, native_field,
            nation_field, job_field, work_place_field, id_field, create_place_field, prev_address_field;
    public DatePicker birth_date_picker, create_date_picker, sign_up_date_picker;
    public Label warning_label;
    public AnchorPane back_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        warning_label.setVisible(false);
        loadGenderCombobox();
        gender_combobox.setValue("Nam");

        back_btn.setOnMouseClicked(mouseEvent -> {
            this.clear_input();
            this.getBackToFamilyInfo();
        });

        add_done_btn.setOnAction(actionEvent -> {
            // TODO: Check valid
            if (validation_check()) {
                warning_label.setVisible(false);

                //TODO: get infor from form
                NhanKhau newNhanKhau = new NhanKhau(Integer.parseInt(this.id_ho), full_name_field.getText(), nick_name_field.getText(),
                        java.sql.Date.valueOf(birth_date_picker.getValue()),
                        gender_combobox.getValue(), born_field.getText(), native_field.getText(), nation_field.getText(), job_field.getText(), work_place_field.getText(),
                        id_field.getText(), java.sql.Date.valueOf(create_date_picker.getValue()), create_place_field.getText(),
                        java.sql.Date.valueOf(sign_up_date_picker.getValue()), prev_address_field.getText());
                // TODO: Add to database
                NhanKhauService.addNhanKhau(newNhanKhau);
                // TODO: Return to Managing View
                ChangeInfo change = new ChangeInfo(1, "Đăng kí thường trú", NhanKhauService.findByName(full_name_field.getText()).get(0), "Thêm nhân khẩu mới", java.sql.Date.valueOf(LocalDate.now()));
                ChangeInfoService.addChangeInfor(change);
                // Model.getInstance().getViewFactory().updateChangeList();
                this.clear_input();
                this.getBackToFamilyInfo();
            } else {
                warning_label.setVisible(true);
            }
        });

        add_cancel_btn.setOnAction(actionEvent -> {
            // TODO: Clear input
            clear_input();
            // TODO: Return to Managing View
            this.getBackToFamilyInfo();
        });
    }

    // TODO: Check for filling all required info
    private boolean validation_check() {
        if (full_name_field.getText().isEmpty()) return false;
        if (born_field.getText().isEmpty()) return false;
        if (native_field.getText().isEmpty()) return false;
        if (nation_field.getText().isEmpty()) return false;
        if (job_field.getText().isEmpty()) return false;
        if (work_place_field.getText().isEmpty()) return false;
        if (id_field.getText().isEmpty()) return false;
        if (create_place_field.getText().isEmpty()) return false;
        return !prev_address_field.getText().isEmpty();
    }

    private void clear_input() {
        full_name_field.clear();
        nick_name_field.clear();
        born_field.clear();
        nation_field.clear();
        native_field.clear();
        job_field.clear();
        work_place_field.clear();
        id_field.clear();
        create_place_field.clear();
        prev_address_field.clear();
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

    private void loadGenderCombobox() {
        gender_combobox.getItems().add("Nam");
        gender_combobox.getItems().add("Nữ");
    }
}
