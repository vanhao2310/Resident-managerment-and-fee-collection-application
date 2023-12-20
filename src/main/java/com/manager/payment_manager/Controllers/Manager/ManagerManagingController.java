package com.manager.payment_manager.Controllers.Manager;

import com.manager.payment_manager.Services.FeeService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

// TODO: CONTROL INSIDE MANAGING
public class ManagerManagingController implements Initializable {
    @FXML
    public ComboBox<String> combobox;
    public Button add_family;
    public VBox family_vbox;

    private String feeType;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // load type
        setComboboxData();
        add_family.setVisible(true);
        feeType = combobox.getValue();
        loadFamily(feeType);
        if (Objects.equals(feeType, "Phí vệ sinh"))
            add_family.setVisible(false);

        combobox.setOnAction(mouseEvent -> {
            feeType = combobox.getValue();
            System.out.println("fee:" + feeType);
            if (Objects.equals(feeType, "Phí vệ sinh")) {
                add_family.setVisible(false);
                System.out.println("no add");
            }
            else
                add_family.setVisible(true);
            loadFamily(feeType);
        });

        System.out.println("feeType: " + feeType);
        add_family.setOnMouseClicked(mouseEvent -> setAdd_family(feeType));
    }

    private void setComboboxData() {
        List<String> nameList = FeeService.getAllFeeName();
        for (String name : nameList)
            combobox.getItems().add(name);
    }

    public void setComboItem(String content) {
        combobox.setValue(content);
    }

    private void loadFamily(String feeType) {
        family_vbox.getChildren().clear();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/FeeList.fxml"));
            Parent familyList = loader.load();
            FeeListController controller = loader.getController();
            // TODO: Xem LoadFamily trong file LeaderManagingController sẽ hiểu
            family_vbox.getChildren().add(familyList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setAdd_family(String feeType) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Manager/AddFamily.fxml"));
            stage.setScene(new Scene(loader.load()));
            AddFamilyController controller = loader.getController();
            controller.setComboItem(feeType);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
