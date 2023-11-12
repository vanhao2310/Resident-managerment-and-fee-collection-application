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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListener();
    }
    private void addListener() {
        dashboard_select.setOnMouseClicked(event -> onDashboard());
        managing_select.setOnMouseClicked(event -> onManaging());
    }


    private void onDashboard() {
        Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Dashboard");
    }
    private void onManaging() {
        Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing");
    }
}
