package com.manager.payment_manager.Controllers.Leader;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LeaderStatisticController implements Initializable {
    public VBox change_vbox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadChangeData();
    }

    private void loadChangeData() {
        change_vbox.getChildren().clear();

        // TODO: TEST DISPLAY
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/ChangeList.fxml"));
            Parent familyList = loader.load();
            // FamilyListController controller = loader.getController();
            change_vbox.getChildren().add(familyList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
