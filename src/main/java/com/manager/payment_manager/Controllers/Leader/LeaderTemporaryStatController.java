package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Model;
import com.manager.payment_manager.Services.ChangeInfoService;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import java.net.URL;
import java.util.ResourceBundle;

public class LeaderTemporaryStatController implements Initializable {
    public HBox back_btn;
    public HBox tempo_container;
    public BarChart<String, Integer> bar_chart;
    public ComboBox<Integer> year_pick;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadBarChart(bar_chart, 2023);
        loadYear(year_pick);
        // System.out.println(ChangeInfoService.countLog(1, 2));
        year_pick.setOnAction(actionEvent -> {
            int cur_year = year_pick.getValue();
            loadBarChart(bar_chart, cur_year);
        });

        back_btn.setOnMouseClicked(mouseEvent -> Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Dashboard"));
    }

    // Tam tru: 2   Tam vang: 3
    private void loadBarChart(BarChart<String, Integer> barChart, int year) {
        barChart.getData().clear();

        XYChart.Series<String, Integer> tru = new XYChart.Series<>();
        tru.getData().add(new XYChart.Data<>("Thường trú", ChangeInfoService.countLog(1, year)));
        tru.getData().add(new XYChart.Data<>("Tạm trú", ChangeInfoService.countLog(2, year)));
        tru.getData().add(new XYChart.Data<>("Tạm vắng", ChangeInfoService.countLog(3, year)));

        barChart.getData().add(tru);
        barChart.setBarGap(10);
        barChart.setCategoryGap(10);
        barChart.setLegendVisible(false);
        colorize(barChart);
    }
    private void loadYear(ComboBox<Integer> yearPick) {
        for (int i = 2023; i >= 1990; i--)
            yearPick.getItems().add(i);
    }
    private void colorize(BarChart<String, Integer> barChart) {
        Node n = barChart.lookup(".data0.chart-bar");
        n.setStyle("-fx-bar-fill: #666370");
        n = barChart.lookup(".data1.chart-bar");
        n.setStyle("-fx-bar-fill: #1C1F33");
        n = barChart.lookup(".data2.chart-bar");
        n.setStyle("-fx-bar-fill: #FF220C");
    }
}
