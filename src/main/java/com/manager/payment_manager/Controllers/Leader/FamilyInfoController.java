package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FamilyInfoController implements Initializable {
    public AnchorPane add_member_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_member_btn.setOnMouseClicked(mouseEvent -> Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set("AddMember"));
    }
}
