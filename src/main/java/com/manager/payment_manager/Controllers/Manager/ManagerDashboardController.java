package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

// TODO: CONTROL INSIDE DASHBOARD
public class ManagerDashboardController implements Initializable {
    public AnchorPane soldier_btn;
    public AnchorPane child_btn;
    public AnchorPane poor_btn;
    public AnchorPane storm_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        soldier_btn.setOnMouseClicked(event -> {
            Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing");
        });
        child_btn.setOnMouseClicked(event -> {
            Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing");
        });
        poor_btn.setOnMouseClicked(event -> {
            Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing");
        });
        storm_btn.setOnMouseClicked(event -> {
            Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("Managing");
        });
    }
}
