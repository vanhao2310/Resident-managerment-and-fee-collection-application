package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class LeaderTimeStatController implements Initializable {
    public HBox back_btn;
    public HBox time_container;
    public ComboBox<Integer> year_pick;
    public LineChart<String, Number> line_chart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadYear();
        back_btn.setOnMouseClicked(mouseEvent -> Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Dashboard"));
    }


    private void loadYear() {
        year_pick.getItems().add(2023);
        year_pick.getItems().add(2022);
        year_pick.getItems().add(2021);
        year_pick.getItems().add(2020);
        year_pick.getItems().add(2019);
        year_pick.getItems().add(2018);
        year_pick.getItems().add(2017);
        year_pick.getItems().add(2016);
        year_pick.getItems().add(2015);
        year_pick.getItems().add(2014);
        year_pick.getItems().add(2013);
        year_pick.getItems().add(2012);
        year_pick.getItems().add(2011);
        year_pick.getItems().add(2010);
    }
}
