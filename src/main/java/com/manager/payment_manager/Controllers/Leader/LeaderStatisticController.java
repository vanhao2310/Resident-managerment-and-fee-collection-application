package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.ChangeInfo;
import com.manager.payment_manager.Services.ChangeInfoService;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LeaderStatisticController implements Initializable {
    public VBox change_vbox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // loadChangeData();
    }

    public void loadChangeData() {
        change_vbox.getChildren().clear();

        List<ChangeInfo> allChangeInfo = ChangeInfoService.getAllChangeInfo();

        if (!allChangeInfo.isEmpty()) {
            for (ChangeInfo ci : allChangeInfo) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/ChangeList.fxml"));
                    Parent ChangeList = loader.load();
                    ChangeListController controller = loader.getController();
                    controller.updateInfo(ci);
                    change_vbox.getChildren().add(ChangeList);
                } catch (IOException e) {
                    System.out.println("error load ChangeList");
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
