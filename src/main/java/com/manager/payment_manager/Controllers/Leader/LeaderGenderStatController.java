package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Model;
import com.manager.payment_manager.Services.NhanKhauService;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class LeaderGenderStatController implements Initializable {
    public HBox back_btn;
    public HBox gender_container;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDataStat();

        back_btn.setOnMouseClicked(mouseEvent -> Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Dashboard"));
    }

    private void loadDataStat() {
        gender_container.getChildren().clear();
        loadBarChart();
        loadTable();
    }

    private void loadBarChart() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Giới tính");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Số lượng");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        XYChart.Series<String, Number> male = new XYChart.Series<>();
        male.getData().add(new XYChart.Data<>("Nam", NhanKhauService.maleCount()));
        male.setName("Nam");
        XYChart.Series<String, Number> female = new XYChart.Series<>();
        female.getData().add(new XYChart.Data<>("Nữ", NhanKhauService.femaleCount()));
        female.setName("Nữ");

        barChart.getData().add(male);
        barChart.getData().add(female);
        barChart.setBarGap(0);
        barChart.setCategoryGap(0);

        gender_container.getChildren().add(barChart);
    }

    private void loadTable() {

    }
}
