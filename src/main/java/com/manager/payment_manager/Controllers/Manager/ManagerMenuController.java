package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

// TODO: CONTROL MENU
public class ManagerMenuController implements Initializable {
    @FXML
    public HBox dashboard_select;
    public HBox managing_select;
    public HBox statistic_select;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dashboard_select.setStyle("-fx-background-color: #BDFEDC;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
        addListener();
    }
    private void addListener() {
        dashboard_select.setOnMouseClicked(event -> onDashboard());
        managing_select.setOnMouseClicked(event -> onManaging());
        statistic_select.setOnMouseClicked(event -> onStatistic());
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Dashboard");
        dashboard_select.setStyle("-fx-background-color: #BDFEDC;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
        managing_select.setStyle("-fx-background-color: #F6F4F5;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
        statistic_select.setStyle("-fx-background-color: #F6F4F5;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
    }
    public void onManaging() {
        Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing");
        dashboard_select.setStyle("-fx-background-color: #F6F4F5;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
        managing_select.setStyle("-fx-background-color: #BDFEDC;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
        statistic_select.setStyle("-fx-background-color: #F6F4F5;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
    }
    private void onStatistic() {
        Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Statistic");
        dashboard_select.setStyle("-fx-background-color: #F6F4F5;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
        managing_select.setStyle("-fx-background-color: #F6F4F5;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
        statistic_select.setStyle("-fx-background-color: #BDFEDC;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
    }
}
