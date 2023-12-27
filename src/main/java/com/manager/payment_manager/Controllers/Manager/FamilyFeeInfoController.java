package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Models.Family;
import com.manager.payment_manager.Models.FeeLog;
import com.manager.payment_manager.Models.Model;
import com.manager.payment_manager.Services.FeeLogService;
import com.manager.payment_manager.Services.FeeService;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class FamilyFeeInfoController implements Initializable {
    public Label id_ho_lbl;
    public Label name_lbl;
    public Label address_lbl;
    public Label type_lbl;
    public Label money_lbl;
    public Button done_fee_btn;
    public Button cancel_btn;
    private int feeId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        done_fee_btn.setOnAction(actionEvent -> {
            // TODO: UPDATE LOG VÀO DATABASE
            FeeLog feeLog = new FeeLog(Integer.parseInt(id_ho_lbl.getText()), this.feeId, Integer.parseInt(money_lbl.getText()),
                    1, java.sql.Date.valueOf(LocalDate.now()));
            FeeLogService.addKhoanThuHo(feeLog);
            Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing");
            Model.getInstance().getViewFactory().updateManagerManaging(type_lbl.getText(), 1);
            Stage stage = (Stage) cancel_btn.getScene().getWindow();
            stage.close();

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
        this.feeId = FeeService.getIdByName(feeName);
    }
}
