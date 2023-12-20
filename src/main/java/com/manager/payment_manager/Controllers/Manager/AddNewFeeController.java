package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
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

                // Update Dashboard
                Model.getInstance().getViewFactory().addNewFee(fee_name_field.getText());
                Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Dashboard");
                // Close Window
                Stage stage = (Stage) add_done_btn.getScene().getWindow();
                stage.close();
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
}
