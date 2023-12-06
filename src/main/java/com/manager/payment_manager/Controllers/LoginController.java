package com.manager.payment_manager.Controllers;

import com.manager.payment_manager.Models.Model;
import com.manager.payment_manager.Services.CheckLoginService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    public Button login_btn;
    public Button leader_btn;
    public TextField user_name_lbl;
    public PasswordField password_lbl;
    public Label login_fail_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_fail_lbl.setVisible(false);
        login_btn.setOnAction(e -> onLoginManager());
        leader_btn.setOnAction(e -> onLoginLeader());
    }

    // TODO: Login successfully
    private void onLoginManager() {
        if (checkFill()){
            System.out.println("Please fill all the fields");
            login_fail_lbl.setVisible(true);
            return;
        }
        if(CheckLoginService.checkLogin(user_name_lbl.getText(), password_lbl.getText(), "manager")) {
            login_fail_lbl.setVisible(false);
            System.out.println("Login successfully");
            Stage stage = (Stage) login_btn.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showManagerWindow();
            System.out.println("Manager Mode");
        }
        else login_fail_lbl.setVisible(true);
    }
    private void onLoginLeader() {
        if(checkFill()){
            login_fail_lbl.setVisible(true);
            System.out.println("Please fill all the fields");
            return;
        }
        if(CheckLoginService.checkLogin(user_name_lbl.getText(), password_lbl.getText(), "leader")) {
            login_fail_lbl.setVisible(false);
            System.out.println("Login successfully");
            Stage stage = (Stage) leader_btn.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showLeaderWindow();
            System.out.println("Leader Mode");
        }
        else login_fail_lbl.setVisible(true);
    }

    private boolean checkFill(){
        return user_name_lbl.getText().isEmpty() || password_lbl.getText().isEmpty();
    }
}
