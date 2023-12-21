package com.manager.payment_manager.Controllers.Manager;

import javafx.scene.control.Label;

public class SubmittedFamController {
    public Label family_id;
    public Label owner_name;
    public Label money;
    public Label address;

    public void setInfor(int family_id, String owner_name, String address, int money){
        this.family_id.setText(String.valueOf(family_id));
        this.owner_name.setText(owner_name);
        this.address.setText(address);
        this.money.setText(String.valueOf(money));
    }
}
