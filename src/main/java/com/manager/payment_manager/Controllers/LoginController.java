package com.manager.payment_manager.Controllers;

import com.manager.payment_manager.Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    public Button login_btn;
    public Button leader_btn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_btn.setOnAction(e -> onLoginManager());
        leader_btn.setOnAction(e -> onLoginLeader());
    }

    // TODO: Login successfully
    private void onLoginManager() {
        Stage stage = (Stage) login_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showManagerWindow();
        System.out.println("Manager Mode");
    }
    private void onLoginLeader() {
        Stage stage = (Stage) leader_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLeaderWindow();
        System.out.println("Leader Mode");
    }
}
