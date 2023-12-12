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
                case "Managing_soldier" -> {
                    manager_parent.setCenter(Model.getInstance().getViewFactory().getManagerManageView("Ủng hộ ngày thương binh liệt sỹ 27/07"));
                    manager_parent.setLeft(Model.getInstance().getViewFactory().updateManagerMenuView("Managing"));
                    // System.out.println("soldier");
                }
                case "Managing_child" -> {
                    manager_parent.setCenter(Model.getInstance().getViewFactory().getManagerManageView("Ủng hộ ngày tết thiếu nhi"));
                    manager_parent.setLeft(Model.getInstance().getViewFactory().updateManagerMenuView("Managing"));
                    // System.out.println("child");
                }
                case "Managing_poor" -> {
                    manager_parent.setCenter(Model.getInstance().getViewFactory().getManagerManageView("Ủng hộ người nghèo"));
                    manager_parent.setLeft(Model.getInstance().getViewFactory().updateManagerMenuView("Managing"));
                    // System.out.println("poor");
                }
                case "Managing_storm" -> {
                    manager_parent.setCenter(Model.getInstance().getViewFactory().getManagerManageView("Trợ giúp đồng bào bị ảnh hưởng bão lụt"));
                    manager_parent.setLeft(Model.getInstance().getViewFactory().updateManagerMenuView("Managing"));
                    // System.out.println("storm");
                }
                case "Dashboard" -> manager_parent.setCenter(Model.getInstance().getViewFactory().getManagerDashboardView());
                case "Managing" -> manager_parent.setCenter(Model.getInstance().getViewFactory().getManagerManagingView());
            }
        });
    }
}
