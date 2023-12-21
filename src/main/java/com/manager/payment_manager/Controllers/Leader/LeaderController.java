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
                case "AddFamily" -> leader_parent.setCenter(Model.getInstance().getViewFactory().getAddFamilyView());
                case "GenderStat" -> leader_parent.setCenter(Model.getInstance().getViewFactory().getLeaderGenderStatView());
                case "AgeStat" -> leader_parent.setCenter(Model.getInstance().getViewFactory().getLeaderAgeStatView());
                case "TimeStat" -> leader_parent.setCenter(Model.getInstance().getViewFactory().getLeaderTimeStatView());
                case "TempoStat" -> leader_parent.setCenter(Model.getInstance().getViewFactory().getLeaderTemporaryStatView());
                default -> leader_parent.setCenter(Model.getInstance().getViewFactory().getLeaderDashboardView());
            }
        }));
    }
}
