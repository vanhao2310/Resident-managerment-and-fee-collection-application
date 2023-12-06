package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Family;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FamilyListController implements Initializable {

    public Label id_lbl;
    public Label name_lbl;
    public Label address_lbl;
    public Label no_people_lbl;
    public Hyperlink detail_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        detail_lbl.setOnMouseClicked(mouseEvent -> {

        });
    }

    public void updateInfo(Family f) {
        id_lbl.setText(String.valueOf(f.getFamilyId()));
        name_lbl.setText(f.getFamilyHead());
        address_lbl.setText(f.getFamilyAddress());
        no_people_lbl.setText(String.valueOf(f.getNumOfPeople()));
    }

}
