/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author danilo
 */
public class DeductionRate {

    private int deductionRateId;
    private String type;
    private String description;
    private double minIncome;
    private double maxIncome;
    private double deductionRate;
    private double amount;

    // Constructors
    public DeductionRate() {
    }

    public DeductionRate(int deductionRateId, String type, String description, double minIncome,
            double maxIncome, double deductionRate, double amount) {
        this.deductionRateId = deductionRateId;
        this.type = type;
        this.description = description;
        this.minIncome = minIncome;
        this.maxIncome = maxIncome;
        this.deductionRate = deductionRate;
        this.amount = amount;
    }

    // Getters and setters
    public int getDeductionRateId() {
        return deductionRateId;
    }

    public void setDeductionRateId(int deductionRateId) {
        this.deductionRateId = deductionRateId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMinIncome() {
        return minIncome;
    }

    public void setMinIncome(double minIncome) {
        this.minIncome = minIncome;
    }

    public double getMaxIncome() {
        return maxIncome;
    }

    public void setMaxIncome(double maxIncome) {
        this.maxIncome = maxIncome;
    }

    public double getDeductionRate() {
        return deductionRate;
    }

    public void setDeductionRate(double deductionRate) {
        this.deductionRate = deductionRate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
