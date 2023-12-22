package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Models.Family;
import com.manager.payment_manager.Services.FeeService;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FamilyFeeInfoController implements Initializable {
    public Label id_ho_lbl;
    public Label name_lbl;
    public Label address_lbl;
    public Label type_lbl;
    public Label money_lbl;
    public Button done_fee_btn;
    public Button cancel_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        done_fee_btn.setOnAction(actionEvent -> {
            // TODO: UPDATE LOG VÀO DATABASE
        });

        cancel_btn.setOnAction(actionEvent -> {
            Stage stage = (Stage) cancel_btn.getScene().getWindow();
            stage.close();
        });
    }

    public void updateInfo(Family family, String feeName) {
        id_ho_lbl.setText(String.valueOf(family.getFamilyId()));
        name_lbl.setText(family.getFamilyHead());
        address_lbl.setText(family.getFamilyAddress());
        type_lbl.setText(feeName);
        // TODO: Load money
        money_lbl.setText(String.valueOf(FeeService.money(feeName, family.getFamilyId())));
    }
}
