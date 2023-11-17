package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AddMemberController implements Initializable {
    public Label return_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        return_btn.setOnMouseClicked(mouseEvent -> {
            Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("Managing");
        });
    }
}
