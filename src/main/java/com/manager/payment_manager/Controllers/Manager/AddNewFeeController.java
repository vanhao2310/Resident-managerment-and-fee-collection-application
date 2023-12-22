package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Models.Fee;
import com.manager.payment_manager.Models.Model;
import com.manager.payment_manager.Services.FeeService;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddNewFeeController implements Initializable {
    public Button add_done_btn;
    public Button cancel_btn;
    public TextField fee_name_field;
    public ComboBox<String> fee_type;
    public DatePicker begin_date;
    public DatePicker end_date;
    public TextField money_field;
    public TextArea info_field;
    public Label warning_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        warning_lbl.setVisible(false);

        cancel_btn.setOnAction(actionEvent -> {
            clearData();
            Stage stage = (Stage) cancel_btn.getScene().getWindow();
            stage.close();
        });

        add_done_btn.setOnAction(actionEvent -> {
            if (!checkInput())
                // If lack info
                warning_lbl.setVisible(true);
            else {
                warning_lbl.setVisible(false);
                // TODO: ADD FEE TO DATABASE
                int feeTypeValue = fee_type.getValue().equals("Bắt buộc") ? 1 : 0;
                int moneyValue = !money_field.getText().isEmpty() ? Integer.parseInt(money_field.getText()) : 0;

                Fee fee;
                if (feeTypeValue == 1) {
                    fee = new Fee(feeTypeValue, fee_name_field.getText(), moneyValue, null, null);
                } else {
                    int defaultValue = 0;
                    LocalDate beginDateValue = begin_date.getValue();
                    LocalDate endDateValue = end_date.getValue();
                    Date beginDate = Date.valueOf(beginDateValue);
                    Date endDate = Date.valueOf(endDateValue);
                    fee = new Fee(feeTypeValue, fee_name_field.getText(), defaultValue, beginDate, endDate);
                }
                FeeService.addKhoanThu(fee);

                // Update Dashboard
                if (fee_type.getValue().equals("Không bắt buộc")) {
                    Model.getInstance().getViewFactory().addNewFee(fee_name_field.getText());
                    Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Dashboard");}

                // Close Window
                Stage stage = (Stage) add_done_btn.getScene().getWindow();
                stage.close();
            }
        });

        loadFeeNameData();
        fee_type.setOnAction(actionEvent -> {
            if (fee_type.getValue().equals("Bắt buộc")) {
                begin_date.setDisable(true);
                end_date.setDisable(true);
            } else {
                begin_date.setDisable(false);
                end_date.setDisable(false);
            }
        });
    }

    boolean checkInput() {
        if (fee_name_field.getText().isEmpty()) return false;
        if (fee_type.getValue().equals("Bắt buộc") && money_field.getText().isEmpty()) return false;
        return !info_field.getText().isEmpty();
    }

    private void clearData() {
        fee_name_field.clear();
        fee_type.setValue("Bắt buộc");
        money_field.clear();
        info_field.clear();
    }

    private void loadFeeNameData() {
        fee_type.getItems().clear();
        List<String> allFeeType = new ArrayList<>();
        allFeeType.add("Bắt buộc");
        allFeeType.add("Không bắt buộc");
        for (String name : allFeeType)
            fee_type.getItems().add(name);
    }
}
