package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Models.Family;
import com.manager.payment_manager.Models.FeeLog;
import com.manager.payment_manager.Services.FamilyService;
import com.manager.payment_manager.Services.FeeLogService;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FeeListController implements Initializable {
    public Label id;
    public Label name;
    public Label address;
    public Label status;
    public Hyperlink details;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    // BẮT BUỘC
    public void updateInfoForce(Family family, int id_khoan_thu, int dot_nop) {
        id.setText(String.valueOf(family.getFamilyId()));
        name.setText(family.getFamilyHead());
        address.setText(family.getFamilyAddress());
        if (FeeLogService.checkSubmit(family.getFamilyId(), id_khoan_thu, dot_nop))
            status.setText("Đã nộp");
        else
            status.setText("Chưa nộp");
    }
    // ĐÓNG GÓP
    public void updateInfoTempo(FeeLog feeLog) {
        id.setText(String.valueOf(feeLog.getHoId()));
        Family family = FamilyService.getFamilyWithID(String.valueOf(feeLog.getHoId()));
        name.setText(family.getFamilyHead());
        address.setText(family.getFamilyAddress());
        status.setText("Đã đóng góp");
    }
}
