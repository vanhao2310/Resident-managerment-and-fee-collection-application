package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Model;
import com.manager.payment_manager.Services.NhanKhauService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class LeaderGenderStatController implements Initializable {
    public HBox back_btn;
    public HBox gender_container;
    public BarChart<String, Number> barChart;
    // Table Property
    public Label male_count_lbl;
    public Label female_count_lbl;
    public Label male_ratio_lbl;
    public Label female_ratio_lbl;
    public PieChart pieChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int male_count = NhanKhauService.maleCount();
        int female_count = NhanKhauService.femaleCount();
        loadDataStat(male_count, female_count);

        back_btn.setOnMouseClicked(mouseEvent -> Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Dashboard"));
    }

    private void loadDataStat(int male_count, int female_count) {
        loadBarChart(male_count, female_count);
        loadTable(male_count, female_count);
        loadPieChart(male_count, female_count);
    }

    private void loadBarChart(int male_count, int female_count) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Nam", male_count));
        series.getData().add(new XYChart.Data<>("Nữ", female_count));

        barChart.getData().add(series);
        barChart.setBarGap(10);
        barChart.setCategoryGap(10);

        Node node = barChart.lookup(".data0.chart-bar");
        node.setStyle("-fx-bar-fill: #8fa1ff");
        node = barChart.lookup(".data1.chart-bar");
        node.setStyle("-fx-bar-fill: #ff81a9");
        barChart.setLegendVisible(false);
    }
    private void loadTable(int male_count, int female_count) {
        male_count_lbl.setText(String.valueOf(male_count));
        female_count_lbl.setText(String.valueOf(female_count));

        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(2);

        double male_ratio = (male_count * 100.0) / (male_count + female_count);
        double female_ratio = 100 - male_ratio;

        male_ratio_lbl.setText(String.valueOf(format.format(male_ratio)));
        female_ratio_lbl.setText(String.valueOf(format.format(female_ratio)));
    }

    private void loadPieChart(int male_count, int female_count) {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
            new PieChart.Data("Nam", male_count),
            new PieChart.Data("Nữ", female_count)
        );
        pieChart.setData(data);
    }
}
