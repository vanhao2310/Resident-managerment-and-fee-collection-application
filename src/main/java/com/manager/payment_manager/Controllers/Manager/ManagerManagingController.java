package com.manager.payment_manager.Controllers.Manager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

// TODO: CONTROL INSIDE MANAGING
public class ManagerManagingController implements Initializable {
    @FXML
    public ComboBox combobox;
    public TableView tableInfo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCombobox();
        setTableData();
    }

    private void setCombobox() {
        combobox.getItems().add("Ủng hộ ngày thương binh liệt sỹ 27/07");
        combobox.getItems().add("Ủng hộ ngày tết thiếu nhi");
        combobox.getItems().add("Ủng hộ người nghèo");
        combobox.getItems().add("Trợ giúp đồng bào bị ảnh hưởng bão lụt");
    }

    private void setTableData() {

    }
}
