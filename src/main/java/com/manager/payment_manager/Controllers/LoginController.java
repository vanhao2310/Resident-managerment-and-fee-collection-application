package com.manager.payment_manager.Controllers;

import com.manager.payment_manager.Views.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    public Button login_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_btn.setOnAction(e -> {
            ViewFactory.getInstance().routes(ViewFactory.SCENE.CLIENT_DASHBOARD);
        });
    }
}
