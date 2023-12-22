package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Models.FeeLog;
import com.manager.payment_manager.Services.FeeLogService;
import com.manager.payment_manager.Services.FeeService;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
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

        // Init - Phí vệ sinh
        List<FeeLog> listInit = FeeLogService.getListFamilyWithPhase(FeeService.getIdByName("Phí vệ sinh"), 1);
        int sum_init = 0;
        // TODO: Load Family into VBox family_container - fxml: SubmittedFam.fxml
        for(FeeLog f : listInit) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/SubmittedFam.fxml"));
                Parent p = loader.load();
                SubmittedFamController controller = loader.getController();
                controller.setInfor(f.getHoId(), f.getHotenChuHo(), f.getDiaChi(), f.getSoTien());
                sum_init += f.getSoTien();
                family_container.getChildren().add(p);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        sum_money.setText(String.valueOf(sum_init));


        combobox_type.setOnAction(actionEvent -> {
            String feeName = combobox_type.getValue();
            loadPhase(feeName);
            family_container.getChildren().clear();
        });

        combobox_phase.setOnAction(actionEvent -> {
            family_container.getChildren().clear();
            int phase;
            if(combobox_phase.getValue() != null)
                phase = combobox_phase.getValue();
            else phase = 1;
            String feeName = combobox_type.getValue();
            int feeId = FeeService.getIdByName(feeName);
            List<FeeLog> listFeeLog = FeeLogService.getListFamilyWithPhase(feeId, phase);
            int sum = 0;

            // TODO: Load Family into VBox family_container - fxml: SubmittedFam.fxml
            for(FeeLog feelog : listFeeLog){
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/SubmittedFam.fxml"));
                    Parent p = loader.load();
                    SubmittedFamController controller = loader.getController();
                    controller.setInfor(feelog.getHoId(), feelog.getHotenChuHo(), feelog.getDiaChi(), feelog.getSoTien());
                    sum += feelog.getSoTien();
                    family_container.getChildren().add(p);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

            // TODO: UPDATE sum_money
            this.sum_money.setText(String.valueOf(sum));
        });
    }

    public void loadType() {
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
