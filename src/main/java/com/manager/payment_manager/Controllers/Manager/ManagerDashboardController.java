package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Models.Model;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

// TODO: CONTROL INSIDE DASHBOARD
public class ManagerDashboardController implements Initializable {
    public AnchorPane soldier_btn;
    public AnchorPane child_btn;
    public AnchorPane poor_btn;
    public AnchorPane storm_btn;
    public Button add_fee;

    // For Update Fee Display
    
    public int row_one_count;
    public int row_two_count;
    public HBox hbox_row_one;
    public HBox hbox_row_two;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        row_one_count = hbox_row_one.getChildren().size();
        row_two_count = hbox_row_two.getChildren().size();

        soldier_btn.setOnMouseClicked(event -> Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing_soldier"));
        child_btn.setOnMouseClicked(event -> Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing_child"));
        poor_btn.setOnMouseClicked(event -> Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing_poor"));
        storm_btn.setOnMouseClicked(event -> Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing_storm"));

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
        AnchorPane container = new AnchorPane();
        container.setPrefHeight(150);
        container.setPrefWidth(426);
        container.setStyle( "-fx-background-color: #edae9d; " +
                            "-fx-background-radius: 10px;\n" +
                            "-fx-border-radius: 20px;");

        AnchorPane image_container = new AnchorPane();
        image_container.setPrefSize(100, 100);
        image_container.setStyle("-fx-background-color: WHITE; " +
                                "-fx-background-radius: 10px;\n" +
                                "-fx-border-radius: 20px;");

//        ImageView image = new ImageView("/Images/dollar_icon.png");
//        image.setFitHeight(80);
//        image.setFitWidth(80);
//        image_container.getChildren().add(image);
//        image.setLayoutX(10);
//        image.setLayoutY(10);

        Label label = new Label(name);
        label.setStyle("-fx-font-weight: bold; -fx-font-size: 20");

        container.getChildren().addAll(image_container, label);
        image_container.setLayoutX(20);
        image_container.setLayoutY(25);
        label.setLayoutX(148);
        label.setLayoutY(50);

        if (row_one_count <= row_two_count) {
            hbox_row_one.getChildren().add(container);
            row_one_count++;
        }
        else {
            hbox_row_two.getChildren().add(container);
            row_two_count++;
        }

        container.setOnMouseClicked(mouseEvent -> Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing"));
        // System.out.println(name);
    }
}
