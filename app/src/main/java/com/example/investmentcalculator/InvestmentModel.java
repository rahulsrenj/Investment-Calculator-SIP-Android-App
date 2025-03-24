package com.example.investmentcalculator;

public class InvestmentModel {
    private String investmentType;
    private int imageRes;

    public InvestmentModel(String investmentType, int imageRes) {
        this.investmentType = investmentType;
        this.imageRes = imageRes;
    }

    public String getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(String investmentType) {
        this.investmentType = investmentType;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }
}
