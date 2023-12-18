package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Family;
import com.manager.payment_manager.Models.Model;
import com.manager.payment_manager.Services.FamilyService;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LeaderManagingController implements Initializable {
    public VBox family_vbox;
    public AnchorPane add_family_btn;

    // TODO: SEARCH FAMILY
    public TextField id_search_field;
    public Button search_family_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.loadFamily();

        add_family_btn.setOnMouseClicked(mouseEvent -> Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("AddFamily"));

        search_family_btn.setOnAction(actionEvent -> {
            if (id_search_field.getText().isEmpty())
                loadFamily();
            else {
                String id_ho = id_search_field.getText();
                loadFamily(id_ho);
            }
        });
    }
    public void loadFamily() {
        family_vbox.getChildren().clear();

        List<Family> allFamily = FamilyService.getAllFamily();
        if(!allFamily.isEmpty()) {
            for (Family f : allFamily) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/FamilyList.fxml"));
                    Parent familyList = loader.load();
                    FamilyListController controller = loader.getController();
                    controller.updateInfo(f);
                    family_vbox.getChildren().add(familyList);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private void loadFamily(String id_ho) {
        family_vbox.getChildren().clear();
        Family result = FamilyService.getFamilyWithID(id_ho);

        if (result != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/FamilyList.fxml"));
                Parent familyList = loader.load();
                FamilyListController controller = loader.getController();
                controller.updateInfo(result);
                family_vbox.getChildren().add(familyList);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}