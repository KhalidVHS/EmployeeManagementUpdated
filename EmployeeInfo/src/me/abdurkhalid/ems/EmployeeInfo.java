/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.abdurkhalid.ems;
import java.io.*;

/**
 *
 * @author 568789
 */
public class EmployeeInfo implements Serializable {
    
    public static final long serialVersionUID =- 2722978263608119832L;
    protected int empnumber;
    protected String firstName;
    protected String lastName;
    protected int sex;
    //Sex, male is 0, female is 1.
    protected int worklocation;
    //0 is mississauga, 1 is Ottowa, 2 is chicago.
    protected double deductionRate;
    
    
    protected EmployeeInfo(int empnumber,String fN, String lN, int sex,int worklocation,double rate) {
    this.empnumber = empnumber;
    this.firstName = fN;
    this.lastName = lN;
    this.sex = sex;
    this.worklocation = worklocation;
    this.deductionRate = 1-rate;
    }
    public int getEmployeeNumber() {
        return empnumber;
    }
    public String getEmployeeFirstName(){
    return firstName;
    }
   public String getEmployeeLastName(){
   return lastName;
   }
   public int getEmployeeSex(){
   return sex;
   }
   public int getEmployeeWorkLocation(){
   return worklocation;
   }
   public double getDeductionRate(){
   return deductionRate;
   }
   public void setEmployeeNumber(int num ) {
   this.empnumber = num;
   }
   public void setEmployeeFirstName (String name) {
   this.firstName = name;
   }        
   public void setEmployeeLastName (String name) {
   this.lastName = name;
   }
   public void setEmployeeSex (int sex){
   this.sex = sex;
   }
   public void setEmployeeLocation (int loc){
   this.worklocation = loc;
   }
   public void setEmployeeDeductionRate (double rate) {
   this.deductionRate = (1-rate);
   }
   

}
    
    

