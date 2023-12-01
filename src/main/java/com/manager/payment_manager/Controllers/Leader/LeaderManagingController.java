package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Model;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LeaderManagingController implements Initializable {
    public AnchorPane add_member_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_member_btn.setOnMouseClicked(mouseEvent -> Model.getInstance().getViewFactory().getLeaderSelectedMenuItem().set("AddMember"));
    }

}
