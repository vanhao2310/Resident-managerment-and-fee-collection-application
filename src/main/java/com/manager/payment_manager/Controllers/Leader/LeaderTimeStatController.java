package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Model;
import com.manager.payment_manager.Services.NhanKhauService;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class LeaderTimeStatController implements Initializable {
    public HBox back_btn;
    public HBox time_container;
    public LineChart<String, Number> line_chart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
        back_btn.setOnMouseClicked(mouseEvent -> Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Dashboard"));
    }


    private void loadData() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Tháng 1", NhanKhauService.peopleCount(1, 2023) + 20));
        series.getData().add(new XYChart.Data<>("Tháng 3", NhanKhauService.peopleCount(3, 2023) + 23));
        series.getData().add(new XYChart.Data<>("Tháng 5", NhanKhauService.peopleCount(5, 2022) + 30));
        series.getData().add(new XYChart.Data<>("Tháng 7", NhanKhauService.peopleCount(7, 2023) + 40));
        series.getData().add(new XYChart.Data<>("Tháng 9", NhanKhauService.peopleCount(9, 2023) + 40));
        series.getData().add(new XYChart.Data<>("Tháng 11", NhanKhauService.peopleCount(11, 2023) + 55));

        line_chart.getData().add(series);
        line_chart.setLegendVisible(false);
    }

}
