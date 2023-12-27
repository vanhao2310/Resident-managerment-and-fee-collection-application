package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Models.Family;
import com.manager.payment_manager.Models.Fee;
import com.manager.payment_manager.Models.FeeLog;
import com.manager.payment_manager.Services.FamilyService;
import com.manager.payment_manager.Services.FeeLogService;
import com.manager.payment_manager.Services.FeeService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

// TODO: CONTROL INSIDE MANAGING
public class ManagerManagingController implements Initializable {
    @FXML
    public ComboBox<String> combobox;
    public Button add_family;
    public VBox family_vbox;
    public ComboBox<Integer> combobox_phase;
    public Label phase_lbl;

    private String feeType;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // load type
        setComboboxData();
        add_family.setVisible(false);
        combobox_phase.setVisible(false);
        phase_lbl.setVisible(false);

        combobox.setOnAction(mouseEvent -> {
            family_vbox.getChildren().clear();
            feeType = combobox.getValue();
            System.out.println("fee: " + feeType);
            add_family.setVisible(FeeService.checkForce(feeType) != 1);
            combobox_phase.setVisible(FeeService.checkForce(feeType) != 1);
            phase_lbl.setVisible(FeeService.checkForce(feeType) != 1);
            loadPhaseData(feeType, 1);
            // loadFamily(feeType, 1);
        });

        combobox_phase.setOnAction(actionEvent -> {
            String feeType;
            if (combobox.getValue() == null)
                feeType = "Phí vệ sinh";
            else
                feeType = combobox.getValue();

            if (combobox_phase.getValue() == null)
                loadFamily(feeType, 1);
            else
                loadFamily(feeType, combobox_phase.getValue());
        });

        // System.out.println("feeType: " + feeType);
        add_family.setOnMouseClicked(mouseEvent -> setAdd_family(feeType));
    }

    public void setComboboxData() {
        combobox.getItems().clear();
        List<String> nameList = FeeService.getAllFeeName();
        for (String name : nameList)
            combobox.getItems().add(name);
    }

    public void setComboItem(String content) {
        combobox.setValue(content);
        // System.out.println("content: " + content);
        // this.feeInit = content;

        loadFamily(content, 1);
        loadPhaseData(content, 1);
    }

    public void loadFamily(String feeType, int phase_num) {
        family_vbox.getChildren().clear();

        // TODO: DISPLAY KHOẢN BẮT BUỘC
        if (FeeService.checkForce(feeType) == 1) {
            List<Family> allFamily = FamilyService.getAllFamily();
            if (!allFamily.isEmpty()) {
                for (Family family : allFamily) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/FeeList.fxml"));
                        Parent feeList = loader.load();
                        FeeListController controller = loader.getController();
                        controller.updateInfoForce(family, FeeLogService.getIdKhoanThuFromKhoanThuLog(feeType));
                        family_vbox.getChildren().add(feeList);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        // TODO: DISPLAY KHOẢN ĐÓNG GÓP
        else {
            List<FeeLog> feeLogs = FeeLogService.getAllLog(feeType, phase_num);
            if (!feeLogs.isEmpty()) {
                for (FeeLog feeLog : feeLogs) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/FeeList.fxml"));
                        Parent feeList = loader.load();
                        FeeListController controller = loader.getController();
                        controller.updateInfoTempo(feeLog);
                        family_vbox.getChildren().add(feeList);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    private void setAdd_family(String feeType) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/AddFamily.fxml"));
            stage.setScene(new Scene(loader.load()));
            AddFamilyController controller = loader.getController();
            controller.setComboItem(feeType);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadPhaseData(String feeName, int phase_default) {
        combobox_phase.getItems().clear();
        int maxPhase = FeeService.phaseMax(feeName);
        for (int i = 1; i <= maxPhase + 1; i++)
            combobox_phase.getItems().add(i);
        combobox_phase.setValue(phase_default);
    }
}
