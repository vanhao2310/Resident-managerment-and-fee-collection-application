package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

// TODO: CONTROL MENU
public class ManagerMenuController implements Initializable {
    @FXML
    public HBox dashboard_select;
    public HBox managing_select;
    public HBox statistic_select;
    public Label dashboard_lbl;
    public Label manage_lbl;
    public Label statistic_lbl;
    public HBox log_out_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setStyleButton("Dashboard");
        addListener();
    }
    private void addListener() {
        dashboard_select.setOnMouseClicked(event -> onDashboard());
        managing_select.setOnMouseClicked(event -> onManaging());
        statistic_select.setOnMouseClicked(event -> onStatistic());
        log_out_btn.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) log_out_btn.getScene().getWindow();
            stage.close();
            Model.getInstance().getViewFactory().showLoginWindow();
        });
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Dashboard");
        setStyleButton("Dashboard");
    }
    public void onManaging() {
        Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing");
        setStyleButton("Managing");
    }
    private void onStatistic() {
        Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Statistic");
        setStyleButton("Statistic");
    }

    public void setStyleButton(String hBox) {
        dashboard_lbl.setStyle("-fx-font-weight: normal");
        manage_lbl.setStyle("-fx-font-weight: normal");
        statistic_lbl.setStyle("-fx-font-weight: normal");

        // System.out.println("Set Button " + hBox);
        switch (hBox) {
            case "Dashboard" -> dashboard_lbl.setStyle("-fx-font-weight: bold");
            case "Managing" -> manage_lbl.setStyle("-fx-font-weight: bold");
            case "Statistic" -> statistic_lbl.setStyle("-fx-font-weight: bold");
        }
    }
}
