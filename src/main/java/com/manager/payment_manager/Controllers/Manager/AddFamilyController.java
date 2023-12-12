package com.manager.payment_manager.Controllers.Manager;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddFamilyController implements Initializable {
    public TextField family_id_field;
    public ComboBox<String> combobox;
    public TextField money_field;
    public Button done_btn;
    public Button cancel_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setComboboxData();
    }

    private void setComboboxData() {
        combobox.getItems().add("Ủng hộ ngày thương binh liệt sỹ 27/07");
        combobox.getItems().add("Ủng hộ ngày tết thiếu nhi");
        combobox.getItems().add("Ủng hộ người nghèo");
        combobox.getItems().add("Trợ giúp đồng bào bị ảnh hưởng bão lụt");
        combobox.getItems().add("Phí vệ sinh");
    }

    public void setComboItem(String content) {
        combobox.setValue(content);
    }
}
