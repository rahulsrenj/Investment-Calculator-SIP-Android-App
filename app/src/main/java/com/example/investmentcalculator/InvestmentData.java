package com.example.investmentcalculator;

import java.util.ArrayList;

public class InvestmentData {
    private double principal;
    private double returns;
    private int year;
    public InvestmentData(double principal, double returns, int year) {
        this.principal = principal;
        this.returns = returns;
        this.year = year;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getReturns() {
        return returns;
    }

    public void setReturns(double returns) {
        this.returns = returns;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public double calculateSipInvestment()
    {
        // Convert annual returns to monthly returns
        double monthlyReturn=returns/12/100;
        // Total months of investment
        int months=12*year;
        double res;
        res=principal*(Math.pow(1+monthlyReturn,months)-1)/ monthlyReturn * (1 + monthlyReturn);

        return  res;


    }
    public double calculateLumpsumInvestment()
    {
        // Convert annual returns to annual rate
        double annualReturn = returns / 100;
        // Lump Sum Future Value formula
        double res = principal * Math.pow(1 + annualReturn, year);

        return res;
    }
}
