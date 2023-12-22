package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Models.Model;
import com.manager.payment_manager.Services.FeeService;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

// TODO: CONTROL INSIDE DASHBOARD
public class ManagerDashboardController implements Initializable {

    public Button add_fee;
    public VBox fee_container;

    // For Update Fee Display

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadFee();


//        soldier_btn.setOnMouseClicked(event -> Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing_soldier"));
//        child_btn.setOnMouseClicked(event -> Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing_child"));
//        poor_btn.setOnMouseClicked(event -> Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing_poor"));
//        storm_btn.setOnMouseClicked(event -> Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing_storm"));

        add_fee.setOnAction(actionEvent -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/AddNewFee.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = new Stage();
                stage.setScene(scene);
                loader.getController();
                stage.show();
            } catch (Exception e) {
                System.out.println("Error loading AddNewFee");
                System.out.println(e.getMessage());
            }
        });
    }

    public void addFee(String name) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/LinkFee.fxml"));
            Parent linkList = loader.load();
            LinkFeeController controller = loader.getController();
            controller.setName(name);
            fee_container.getChildren().add(linkList);
        } catch (Exception e) {
            System.out.println("Error loading feeName");
            System.out.println(e.getMessage());
        }
    }

    public void loadFee() {
        fee_container.getChildren().clear();
        List<String> allFee = FeeService.getAllFeeName();
        if (!allFee.isEmpty()) {
            for (String feeName : allFee) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/LinkFee.fxml"));
                    Parent linkList = loader.load();
                    LinkFeeController controller = loader.getController();
                    controller.setName(feeName);
                    fee_container.getChildren().add(linkList);
                } catch (Exception e) {
                    System.out.println("Error loading feeName");
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
