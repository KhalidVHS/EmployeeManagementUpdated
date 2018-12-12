/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.abdurkhalid.ems;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Abdurk
 */
public class scratchFile {

    public final void LoadFromFile() {
        try {
            FileInputStream file = new FileInputStream("employeeobjects.ser");
            ObjectInputStream objectsIn = new ObjectInputStream(file);
            ArrayList<EmployeeInfo> LoadedList = (ArrayList) objectsIn.readObject();
            file.close();
            objectsIn.close();
            for (int i = 0; i < LoadedList.size(); i++) {
                if (LoadedList.get(i) instanceof PartTimeEmployee) {
                    PartTimeEmployee empAdding = (PartTimeEmployee)LoadedList.get(i);
                    mainjframe.theHash.addToBucket(empAdding);
                    
                    //PartTimeEmployee empAdding = new PartTimeEmployee(LoadedList.get(i).getEmployeeNumber(),
                    //        LoadedList.get(i).getEmployeeFirstName(), LoadedList.get(i).getEmployeeLastName(), LoadedList.get(i).getEmployeeSex(), LoadedList.get(i).getEmployeeWorkLocation(),
                    //        LoadedList.get(i).getDeductionRate(), LoadedList.get(i).getHourlyWage(), LoadedList.get(i).getHoursPerWeek(), LoadedList.get(i).getWeeksPerYear());
                    //        mainjframe.theHash.addToBucket(empAdding);
                } else if (LoadedList.get(i) instanceof FullTimeEmployee) {
                    FullTimeEmployee empAdding = (FullTimeEmployee)LoadedList.get(i);
                    mainjframe.theHash.addToBucket(empAdding);
                        //FullTimeEmployee empAdding = new FullTimeEmployee(LoadedList.get(i).getEmployeeNumber(),
                            //LoadedList.get(i).getEmployeeFirstName(), LoadedList.get(i).getEmployeeLastName(), LoadedList.get(i).getEmployeeSex(), LoadedList.get(i).getEmployeeWorkLocation(),
                            //LoadedList.get(i).getDeductionRate(),LoadedList.get(i).getYearlySalary());
                            //mainjframe.theHash.addToBucket(empAdding);
                }
            }
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee Class Not Found!");
            c.printStackTrace();
            return;
        } catch (ClassCastException a) {
            System.out.println("Couldnt run the loading from file!");
            a.printStackTrace();
            return;
        }
        catch (Exception m){
        m.printStackTrace();
        return;}
    }
}
