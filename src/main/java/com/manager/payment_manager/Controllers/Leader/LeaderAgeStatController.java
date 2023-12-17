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
import java.util.ResourceBundle;

public class LeaderAgeStatController implements Initializable {
    public HBox back_btn;
    public HBox age_container;
    public BarChart<String, Number> barChart;
    public Label one_lbl;
    public Label two_lbl;
    public Label three_lbl;
    public Label four_lbl;
    public Label five_lbl;
    public PieChart pieChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int tre_em = NhanKhauService.ageRangeCount(0, 17);
        int thanh_thieu_nien = NhanKhauService.ageRangeCount(18, 24);
        int thanh_nien = NhanKhauService.ageRangeCount(25, 34);
        int trung_nien = NhanKhauService.ageRangeCount(35, 54);
        int cao_tuoi = NhanKhauService.ageRangeCount(55, 120);

        loadDataStat(tre_em, thanh_thieu_nien, thanh_nien, trung_nien, cao_tuoi);
        back_btn.setOnMouseClicked(mouseEvent -> Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Dashboard"));
    }

    private void loadDataStat(int tre_em, int thanh_thieu_nien, int thanh_nien, int trung_nien, int cao_tuoi) {
        loadBarChart(tre_em, thanh_thieu_nien, thanh_nien, trung_nien, cao_tuoi);
        loadTable(tre_em, thanh_thieu_nien, thanh_nien, trung_nien, cao_tuoi);
        loadPieChart(tre_em, thanh_thieu_nien, thanh_nien, trung_nien, cao_tuoi);
    }

    private void loadBarChart(int tre_em, int thanh_thieu_nien, int thanh_nien, int trung_nien, int cao_tuoi) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Trẻ em", tre_em));
        series.getData().add(new XYChart.Data<>("Thanh thiếu niên", thanh_thieu_nien));
        series.getData().add(new XYChart.Data<>("Thanh niên", thanh_nien));
        series.getData().add(new XYChart.Data<>("Trung niên", trung_nien));
        series.getData().add(new XYChart.Data<>("Cao tuổi", cao_tuoi));

        barChart.getData().add(series);
        barChart.setBarGap(10);
        barChart.setCategoryGap(10);

        Node n = barChart.lookup(".data0.chart-bar");
        n.setStyle("-fx-bar-fill: #f79d84");
        n = barChart.lookup(".data1.chart-bar");
        n.setStyle("-fx-bar-fill: #fac05e");
        n = barChart.lookup(".data2.chart-bar");
        n.setStyle("-fx-bar-fill: #3fa7d6");
        n = barChart.lookup(".data3.chart-bar");
        n.setStyle("-fx-bar-fill: #59cd90");
        n = barChart.lookup(".data4.chart-bar");
        n.setStyle("-fx-bar-fill: #ee6352");

        barChart.setLegendVisible(false);
    }

    private void loadTable(int tre_em, int thanh_thieu_nien, int thanh_nien, int trung_nien, int cao_tuoi) {
        one_lbl.setText(String.valueOf(tre_em));
        two_lbl.setText(String.valueOf(thanh_thieu_nien));
        three_lbl.setText(String.valueOf(thanh_nien));
        four_lbl.setText(String.valueOf(trung_nien));
        five_lbl.setText(String.valueOf(cao_tuoi));
    }

    private void loadPieChart(int tre_em, int thanh_thieu_nien, int thanh_nien, int trung_nien, int cao_tuoi) {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
                new PieChart.Data("Trẻ em", tre_em),
                new PieChart.Data("Thanh thiếu niên", thanh_thieu_nien),
                new PieChart.Data("Thanh niên", thanh_nien),
                new PieChart.Data("Trung niên", trung_nien),
                new PieChart.Data("Cao tuổi", cao_tuoi)
        );
        pieChart.setData(data);
    }
}
