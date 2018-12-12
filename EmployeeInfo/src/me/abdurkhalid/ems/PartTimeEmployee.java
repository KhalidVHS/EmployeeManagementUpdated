/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.abdurkhalid.ems;
import me.abdurkhalid.ems.EmployeeInfo;

/**
 *
 * @author 568789
 */
public class PartTimeEmployee extends EmployeeInfo {
    private double hourlyWage;
    private double hoursPerWeek;
    private double weeksPerYear;

    public PartTimeEmployee (int number,String firstName, String lastName, int sex, int worklocation, double deductionRate,
            double hourlyWage,double hoursPerWeek, double weeksPerYear){
        super(number,firstName,lastName,sex,worklocation,deductionRate);
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
        this.weeksPerYear = weeksPerYear;
    }
    public double calcAnnualIncome() {
         double salary = (this.hourlyWage*this.hoursPerWeek*this.weeksPerYear);
         return salary;
    }
    
    public double calcDeductions(double rate) {
        double salaryAfterDeduction = (calcAnnualIncome()*(1-rate));
        return salaryAfterDeduction;
    }
    public double getHourlyWage(){
    return this.hourlyWage;
    }
    public double getHoursPerWeek(){
    return this.hoursPerWeek;
    }
    public double getWeeksPerYear(){
    return this.weeksPerYear;
    }
    
}
