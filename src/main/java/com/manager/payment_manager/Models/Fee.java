package com.manager.payment_manager.Models;

public class Fee {
    private int id;
    private int fee_type;
    private String fee_name;

    public Fee (int id, int fee_type, String fee_name) {
        this.id = id;
        this.fee_type = fee_type;
        this.fee_name = fee_name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getFee_type() {
        return fee_type;
    }
    public void setFee_type(int fee_type) {
        this.fee_type = fee_type;
    }
    public String getFee_name() {
        return fee_name;
    }
    public void setFee_name(String fee_name) {
        this.fee_name = fee_name;
    }

}
