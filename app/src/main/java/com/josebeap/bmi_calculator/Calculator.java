package com.josebeap.bmi_calculator;

public class Calculator {

    private double height=0;
    private double weight=0;

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double calculateBMI (){

        double BMI = weight/Math.pow(height,2);

        return BMI;
    }
}
