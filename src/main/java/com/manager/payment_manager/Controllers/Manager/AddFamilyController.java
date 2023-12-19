package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Services.FeeService;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddFamilyController implements Initializable {
    public TextField family_id_field;

    public ComboBox<String> combobox; // feeName
    public TextField money_field;
    public ComboBox<Integer> combobox_phase;
    public Button add_done_btn;
    public Button cancel_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadFeeNameData();

        combobox.setOnAction(actionEvent -> {
            String feeName = combobox.getValue();
            System.out.println(feeName);
            loadPhaseData(feeName);
        });
    }

    private void loadFeeNameData() {
        combobox.getItems().clear();
        List<String> allFeeName = FeeService.getAllFeeName();
        for (String name : allFeeName)
            combobox.getItems().add(name);
    }

    private void loadPhaseData(String feeName) {
        combobox_phase.getItems().clear();
        int maxPhase = FeeService.phaseMax(feeName);
        for (int i = 1; i <= maxPhase; i++)
            combobox_phase.getItems().add(i);
    }

    public void setComboItem(String content) {
        combobox.setValue(content);
    }
}
