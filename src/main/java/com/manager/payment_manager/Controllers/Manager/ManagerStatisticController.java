package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Services.FeeService;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ManagerStatisticController implements Initializable {
    public ComboBox<String> combobox_type;
    public ComboBox<Integer> combobox_phase;
    public Label sum_money;
    public VBox family_container; // load family into this

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadType();

        combobox_type.setOnAction(actionEvent -> {
            String feeName = combobox_type.getValue();
            System.out.println(feeName);
            loadPhase(feeName);
        });

        combobox_phase.setOnAction(actionEvent -> {
            // TODO: UPDATE sum_money
            // TODO: Load Family into VBox family_container - fxml: SubmittedFam.fxml
        });
    }

    private void loadType() {
        List<String> allFeeName = FeeService.getAllFeeName();
        combobox_type.getItems().clear();
        for (String name : allFeeName)
            combobox_type.getItems().add(name);
    }
    private void loadPhase(String feeName) {
        int phaseMax = FeeService.phaseMax(feeName);
        combobox_phase.getItems().clear();
        for (int i = 1; i <= phaseMax; i++)
            combobox_phase.getItems().add(i);
    }
}
