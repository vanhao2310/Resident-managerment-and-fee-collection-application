package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Family;
import com.manager.payment_manager.Models.Model;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.manager.payment_manager.Services.FamilyService.getAllFamily;

public class LeaderManagingController implements Initializable {
    public AnchorPane add_member_btn;
    public VBox family_vbox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadFamily();
        add_member_btn.setOnMouseClicked(mouseEvent -> Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("AddMember"));
    }

    private void loadFamily() {
        family_vbox.getChildren().clear();

        List<Family> allFamily = getAllFamily();
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
}