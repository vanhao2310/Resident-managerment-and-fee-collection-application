package com.manager.payment_manager.Controllers.Leader;

import com.manager.payment_manager.Models.Family;
import com.manager.payment_manager.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class FamilyListController implements Initializable {
    public CheckBox delete_check_box;
    private String id_ho;
    public Label id_lbl;
    public Label name_lbl;
    public Label address_lbl;
    public Hyperlink detail_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        detail_lbl.setOnMouseClicked(mouseEvent -> {
            this.id_ho = this.id_lbl.getText();
            Model.getInstance().getViewFactory().showFamilyDetail();
            Model.getInstance().getViewFactory().updateFamilyDetail(id_ho);
            // System.out.println(id_ho);
        });
    }

    public void updateInfo(Family f) {
        id_lbl.setText(String.valueOf(f.getFamilyId()));
        name_lbl.setText(f.getFamilyHead());
        address_lbl.setText(f.getFamilyAddress());
    }
    public boolean isChecked(){
        return this.delete_check_box.isSelected();
    }
}
