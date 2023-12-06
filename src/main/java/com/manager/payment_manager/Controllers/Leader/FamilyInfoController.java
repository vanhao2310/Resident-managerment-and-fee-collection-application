package com.manager.payment_manager.Controllers.Leader;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class FamilyInfoController implements Initializable {
    public AnchorPane add_member_btn;
    public Label chu_ho_lbl;
    public Label address_lbl;
    public Label id_ho_lbl;

    public void updateFamilyInfo(String id_ho) {
        System.out.println(id_ho);
        System.out.println(id_ho_lbl.getText());
        this.id_ho_lbl.setText(id_ho);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_member_btn.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) add_member_btn.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Leader/AddMember.fxml"));
            try {
                stage.setScene(new Scene(loader.load()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }


}
