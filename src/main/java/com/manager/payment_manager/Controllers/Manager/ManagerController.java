package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import java.util.ResourceBundle;

// TODO: CONTROL ALL WINDOW
public class ManagerController implements Initializable {
    public BorderPane manager_parent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getManagerSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal) {
                case "Dashboard" -> manager_parent.setCenter(Model.getInstance().getViewFactory().getManagerDashboardView());
                case "Managing" -> manager_parent.setCenter(Model.getInstance().getViewFactory().getManagerManagingView());
                case "Statistic" -> manager_parent.setCenter(Model.getInstance().getViewFactory().getManagerStatisticView());

                default -> {
//                  System.out.println(newVal);
                    manager_parent.setCenter(Model.getInstance().getViewFactory().getManagerManageView(newVal));
//                  Model.getInstance().getViewFactory().updateManagerMenuView("Managing");
                }
            }
        });
    }
}
