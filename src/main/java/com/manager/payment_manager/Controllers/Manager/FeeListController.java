package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Models.Family;
import com.manager.payment_manager.Models.FeeLog;
import com.manager.payment_manager.Models.Model;
import com.manager.payment_manager.Services.FamilyService;
import com.manager.payment_manager.Services.FeeLogService;
import com.manager.payment_manager.Services.FeeService;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FeeListController implements Initializable {
    public Label id;
    public Label name;
    public Label address;
    public Label status;
    public Hyperlink submit_hl;

    private Family family;
    private int id_khoan_thu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        submit_hl.setOnMouseClicked(mouseEvent -> {
            Model.getInstance().getViewFactory().showFamilyFeeInfo(family, FeeService.getNameById(id_khoan_thu));
        });
    }

    // BẮT BUỘC
    public void updateInfoForce(Family family, int id_khoan_thu) {
        this.family = family;
        this.id_khoan_thu = id_khoan_thu;
        id.setText(String.valueOf(family.getFamilyId()));
        name.setText(family.getFamilyHead());
        address.setText(family.getFamilyAddress());
        if (FeeLogService.checkSubmit(family.getFamilyId(), id_khoan_thu, 0)) {
            status.setText("Đã nộp");
            submit_hl.setDisable(true);
        }
        else {
            status.setText("Chưa nộp");
            submit_hl.setDisable(false);
        }
    }
    // ĐÓNG GÓP
    public void updateInfoTempo(FeeLog feeLog) {
        id.setText(String.valueOf(feeLog.getHoId()));
        Family family = FamilyService.getFamilyWithID(String.valueOf(feeLog.getHoId()));
        name.setText(family.getFamilyHead());
        address.setText(family.getFamilyAddress());
        status.setText("Đã đóng góp");
        submit_hl.setDisable(true);
    }
}
