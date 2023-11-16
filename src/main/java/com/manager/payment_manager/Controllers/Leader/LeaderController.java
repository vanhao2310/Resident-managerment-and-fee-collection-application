package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LeaderController implements Initializable {
    public BorderPane leader_parent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().addListener(((observableValue, oldVal, newVal) -> {
            switch (newVal) {
                case "Managing" -> leader_parent.setCenter(Model.getInstance().getViewFactory().getLeaderManagingView());
                case "Statistic" -> leader_parent.setCenter(Model.getInstance().getViewFactory().getLeaderStatisticView());
                default -> leader_parent.setCenter(Model.getInstance().getViewFactory().getLeaderDashboardView());
            }
        }));
    }
}
