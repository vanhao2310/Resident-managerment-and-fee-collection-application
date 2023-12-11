package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AddFamilyController implements Initializable {
    public TextField family_id; // số hộ khẩu
    public TextField owner_name_lbl; // tên chủ hộ
    public TextField house_num_lbl; // số nhà
    public TextField street_lbl; // tên đường
    public TextField town_lbl; // phường / xã / thị trấn
    public TextField city_lbl; // thành phố
    public Label warning_label;
    public AnchorPane back_btn;
    public Button add_done_btn;
    public Button add_cancel_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        warning_label.setVisible(false);

        back_btn.setOnMouseClicked(mouseEvent -> Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Managing"));

        add_done_btn.setOnAction(actionEvent -> {
            if (validation_check()) {
                // save family

                // back to managing
                clear_input();
                Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Managing");
            } else {
                warning_label.setVisible(true);
            }
        });

        add_cancel_btn.setOnAction(actionEvent -> {
            // clear data
            clear_input();
            warning_label.setVisible(false);
            // back to managing
            Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Managing");
        });
    }

    private boolean validation_check() {
        if (family_id.getText().isEmpty()) return false;
        if (owner_name_lbl.getText().isEmpty()) return false;
        if (house_num_lbl.getText().isEmpty()) return false;
        if (street_lbl.getText().isEmpty()) return false;
        if (town_lbl.getText().isEmpty()) return false;
        return !city_lbl.getText().isEmpty();
    }

    private void clear_input() {
        family_id.clear();
        owner_name_lbl.clear();
        house_num_lbl.clear();
        street_lbl.clear();
        town_lbl.clear();
        city_lbl.clear();
    }
}
