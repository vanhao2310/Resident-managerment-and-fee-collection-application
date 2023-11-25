package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddMemberController implements Initializable {
    // BUTTON
    @FXML
    public Label return_btn;
    @FXML
    public Button add_done_btn;
    @FXML
    public Button add_cancel_btn;

    // DATA INPUT
    /* TODO: INPUT INFO
    * full_name_field - Họ và tên
    * nick_name_field - Bí danh
    * birth_date_picker - ngày sinh
    * born_field - nơi sinh
    * native_field - nguyên quán
    * nation_field - dân tộc
    * job_field - nghề nghiệp
    * work_place_field - nơi làm việc
    * id_field - số CMND/CCCD
    * create_place_field - nơi cấp CMND/CCCD
    * create_date_picker - ngày cấp
    * sign_up_date_picker - ngày đăng ký thường trú
    * prev_address_field - địa chỉ thường trú trước khi chuyển đến
    * */
    public TextField full_name_field, nick_name_field, born_field, native_field,
            nation_field, job_field, work_place_field, id_field, create_place_field, prev_address_field;
    public DatePicker birth_date_picker, create_date_picker, sign_up_date_picker;
    public Label warning_label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        warning_label.setVisible(false);

        return_btn.setOnMouseClicked(mouseEvent -> Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Managing"));

        add_done_btn.setOnAction(actionEvent -> {
            // TODO: Check valid
            if (validation_check()) {
                warning_label.setVisible(false);
                // TODO: Add to database

                // TODO: Return to Managing View
                Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Managing");
            } else {
                warning_label.setVisible(true);
            }
        });

        add_cancel_btn.setOnAction(actionEvent -> {
            // TODO: Clear input

            // TODO: Return to Managing View
            Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Managing");
        });
    }

    boolean validation_check() {
        if (full_name_field.getText().isEmpty()) return false;
        if (nick_name_field.getText().isEmpty()) return false;
        if (born_field.getText().isEmpty()) return false;
        if (native_field.getText().isEmpty()) return false;
        if (nation_field.getText().isEmpty()) return false;
        if (job_field.getText().isEmpty()) return false;
        if (work_place_field.getText().isEmpty()) return false;
        if (id_field.getText().isEmpty()) return false;
        if (create_place_field.getText().isEmpty()) return false;
        return !prev_address_field.getText().isEmpty();
    }
}
