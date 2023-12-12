package com.manager.payment_manager.Models;

public class Family {
    private int familyId;
    private String familyHead;
    private String familyAddress;
    private int numOfPeople;

    public Family(int id, String head, String address, int numOfPeople) {
        this.familyId = id;
        this.familyHead = head;
        this.familyAddress = address;
        this.numOfPeople = numOfPeople;
    }

    public Family(String familyHead, String familyAddress, int numOfPeople) {
        this.familyHead = familyHead;
        this.familyAddress = familyAddress;
        this.numOfPeople = numOfPeople;
    }

    public int getFamilyId() {
        return familyId;
    }
    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }
    public String getFamilyHead() {
        return familyHead;
    }
    public void setFamilyHead(String familyHead) {
        this.familyHead = familyHead;
    }
    public String getFamilyAddress() {
        return familyAddress;
    }
    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress;
    }
    public int getNumOfPeople() {
        return numOfPeople;
    }
    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }
}
