package com.nipuni.test.controller.DTO;

public class Bankdto {
    private String bankName;
    private int bankId;

    public Bankdto(String bankName) {
        this.bankName = bankName;

    }

    public Bankdto() {
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }
}
