package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;

import java.net.URL;
import java.util.ResourceBundle;

public class LinkFeeController implements Initializable {
    public Hyperlink link;

    public void setName(String name) {
        link.setText(name);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        link.setOnMouseClicked(mouseEvent -> {
            Model.getInstance().getViewFactory().getManagerSelectedMenuItem().set(link.getText());
            Model.getInstance().getViewFactory().updateManagerMenuView("Managing");
        });
    }
}
