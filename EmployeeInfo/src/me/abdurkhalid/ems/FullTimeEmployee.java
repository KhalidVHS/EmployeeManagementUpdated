/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.abdurkhalid.ems;

/**
 *
 * @author 568789
 */
public class FullTimeEmployee extends EmployeeInfo{
    
    protected double yearlySalary;
    
    public FullTimeEmployee (int number,String firstName, String lastName, int sex, int worklocation, double deductionRate,double salary) {
        super(number,firstName,lastName,sex,worklocation,deductionRate);
        this.yearlySalary = salary;
    }
    public double calcDeductions(double rate) {
    double salaryAfterDeductions = yearlySalary*(1-this.deductionRate);
    return salaryAfterDeductions;
    }
    public double getYearlySalary() {
    return yearlySalary;
    }
}
