package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LeaderMenuController implements Initializable {
    @FXML
    public HBox dashboard_select;
    public HBox managing_select;
    public HBox statistic_select;
    public HBox logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dashboard_select.setStyle("-fx-background-color: #BDFEDC;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
        addListener();
    }
    private void addListener() {
        dashboard_select.setOnMouseClicked(event -> onDashboard());
        managing_select.setOnMouseClicked(event -> onManaging());
        statistic_select.setOnMouseClicked(event -> onStatistic());
        logout_btn.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) logout_btn.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showLoginWindow();
        });
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Dashboard");
        dashboard_select.setStyle("-fx-background-color: #BDFEDC;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
        managing_select.setStyle("-fx-background-color: #F6F4F5;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
        statistic_select.setStyle("-fx-background-color: #F6F4F5;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
    }
    public void onManaging() {
        Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Managing");
        dashboard_select.setStyle("-fx-background-color: #F6F4F5;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
        managing_select.setStyle("-fx-background-color: #BDFEDC;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
        statistic_select.setStyle("-fx-background-color: #F6F4F5;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
    }
    private void onStatistic() {
        Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Statistic");
        dashboard_select.setStyle("-fx-background-color: #F6F4F5;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
        managing_select.setStyle("-fx-background-color: #F6F4F5;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
        statistic_select.setStyle("-fx-background-color: #BDFEDC;" + "-fx-background-radius: 10px;" + "-fx-border-radius: 20px;");
    }
}
