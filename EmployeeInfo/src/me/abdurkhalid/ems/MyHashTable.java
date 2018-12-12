package me.abdurkhalid.ems;

//The imports below are for the arraylist package and the scanner package, which is just the user input asker.
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import static me.abdurkhalid.ems.mainjframe.theHash;

//The attributes  for the hastable are just istantiating the table and saying studentsInBuckets is equal to zero.
//If the user wants to retrieve how many students there are in the buckets, then they can use the function studentNumInBuckets().
public class MyHashTable {

    private static ArrayList<EmployeeInfo>[] bigbuckets;
    private int employeesInBuckets = 0;
    static ArrayList<EmployeeInfo> savedList = new ArrayList<EmployeeInfo>();
    static ArrayList<EmployeeInfo> addingtojtable = new ArrayList<EmployeeInfo>();

    //The function below just returns the variable value for studentInNumBuckets becaause the variable is set to private.
    public int employeesNumInBuckets() {
        return employeesInBuckets;
    }

    //The constructor below for the hashtable just creates the number of arraylists you want within each position of the buckets
    //Array, by using the for loop to do so.
    public MyHashTable(int howManyBuckets) {
        bigbuckets = new ArrayList[howManyBuckets];
        for (int i = 0; i < howManyBuckets; i++) {
            bigbuckets[i] = new ArrayList<EmployeeInfo>();
        }
    }

    //To first find which bucket the student goes into we calculate the studentnumber with modulo.
    //The remainedr is the bucket that the student gets passed into.
    //After the student is added, the studentInBuckets variable gets increased by 1.
    public void addToBucket(EmployeeInfo employeePassingThrough)throws Exception {
        int wherenumgoes = calcNumBuckets(employeePassingThrough.getEmployeeNumber());
        for (int i = 0;i <bigbuckets[wherenumgoes].size();i++ ){
        if (bigbuckets[wherenumgoes].get(i).getEmployeeNumber() == employeePassingThrough.getEmployeeNumber())
            throw new Exception();
            }
        bigbuckets[wherenumgoes].add(employeePassingThrough);
        employeesInBuckets++;
       
    }

    //The removeFromTable Removes the student from the list but doesn't return object reference value.
    //Instead the function prints out the students number out to the console.
    //It loops through the bucket that was calculated through modulo and then sees if the number matches anything in the list.
    //If it does match the number in the array list, it prints the number out.
    public void removeFromTable(int employeeBeingRemoved) {
        int arrayListLocation = calcNumBuckets(employeeBeingRemoved);
        for (int i = 0; i < bigbuckets[arrayListLocation].size(); i++) {
            if (employeeBeingRemoved == bigbuckets[arrayListLocation].get(i).getEmployeeNumber()) {
                System.out.println("The employee number being removed is" + employeeBeingRemoved);
                bigbuckets[arrayListLocation].remove(i);
            } else {
                System.out.println("There is no employee with that number in the list!");
                return;
            }
        }
    }

    //The function below returns the student reference value, rather than the function above that just returns the number.
    //Using the type class student info, it returns the reference as an object.
    public EmployeeInfo removeStudent(int employeenumber) {
        int bucketpos = calcNumBuckets(employeenumber);
        for (int i = 0; i < bigbuckets[bucketpos].size(); i++) {
            if (bigbuckets[bucketpos].get(i) == null) {
                return null;
            } else {
                EmployeeInfo employeereturning = bigbuckets[bucketpos].get(i);
                return employeereturning;
            }

        }
        return null;
    }
    //The searchtable function takes in the student number that the user wants to look for.
    //It uses the modulo function to find which bucket its put into and then prints out which bucket its in.
    //It also prints the position of the student in the arraylist of the bucket.

    public EmployeeInfo searchTableEnum(int employeeSearch) {
        int pos = calcNumBuckets(employeeSearch);
        for (int l = 0; l < bigbuckets[pos].size(); l++) {
            if (employeeSearch == bigbuckets[pos].get(l).getEmployeeNumber()) {
                EmployeeInfo returningEmployee = bigbuckets[pos].get(l);
                return returningEmployee;
            } else if (l + 1 != bigbuckets[pos].get(l).getEmployeeNumber()) {
               return null; 
            }
        }
        return null;
    }

    public EmployeeInfo searchTable(EmployeeInfo employeeSearch) {
        int pos = calcNumBuckets(employeeSearch.getEmployeeNumber());
        for (int l = 0; l < bigbuckets[pos].size(); l++) {
            if (employeeSearch.getEmployeeNumber() == bigbuckets[pos].get(l).getEmployeeNumber()) {
                return employeeSearch;
            } else if (l + 1 != bigbuckets[pos].get(l).getEmployeeNumber()) {
                return null;
            }
        }
        return null;
    }

    //The calnumbuckets function just does a modulo of the studentnumber passing through and returns the remainder in the variable
    //"wherenumgoes"
    public int calcNumBuckets(int employee) {
        int wherenumgoes = employee % bigbuckets.length;
        return wherenumgoes;
    }
    //DISPLAY THE TABLE FUNCTIONS
    //displayBucket displays what the student number are for a SPECIFIC bucket.
    //displaytable displays every arraylist in ALL the buckets,with all the student numbers.

    public void displayBucket(int bucket) {
        int pos = bucket;
        for (int i = 0; i < bigbuckets[pos].size(); i++) {
            System.out.println("The chosen bucket to search is bucket" + bucket);
            System.out.println("Employee name is" + bigbuckets[pos].get(i).getEmployeeFirstName() + "And their student number is"
                    + bigbuckets[pos].get(i).getEmployeeNumber());
            //System.out.println("The items in bucket" + bucket + "are" + bigbuckets[pos].get(i))
        }

    }

    public void displayTable() {
        for (int tablepos = 0; tablepos < bigbuckets.length; tablepos++) {
            for (int i = 0; i < bigbuckets[tablepos].size(); i++) {
                if (bigbuckets[tablepos].get(i).getEmployeeNumber() != 0) {
                    System.out.println(bigbuckets[tablepos].get(i).getEmployeeNumber());
                    return;
                } else {
                    System.out.println("There are no items in the list!");
                    return;
                }
            }
        }
    }
    public static void deleteTable(){
    for (int k = 0; k< bigbuckets.length;k++){
        for (int j = 0; j < bigbuckets[k].size();j++){
            bigbuckets[k].remove(j);
        }
    }
  }

    public final void saveToFile() {
        for (int tablepos = 0; tablepos < bigbuckets.length; tablepos++) {
            for (int i = 0; i < bigbuckets[tablepos].size(); i++) {
                savedList.add(bigbuckets[tablepos].get(i));
                System.out.println(savedList);
            }
        }
        try {
            FileOutputStream file = new FileOutputStream("employeeobjects.ser");
            ObjectOutputStream objectsin = new ObjectOutputStream(file);
            objectsin.writeObject(savedList);
            file.close();
            objectsin.close();
            System.out.println("The Employee Has been saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void LoadFromFile() {
        try {
            deleteTable();
            FileInputStream file = new FileInputStream("employeeobjects.ser");
            ObjectInputStream objectsIn = new ObjectInputStream(file);
            ArrayList<EmployeeInfo> LoadedList = (ArrayList) objectsIn.readObject();
            file.close();
            objectsIn.close();
            for (int i = 0; i < LoadedList.size(); i++) {
                if (LoadedList.get(i) instanceof PartTimeEmployee) {
                    PartTimeEmployee empAdding = (PartTimeEmployee) LoadedList.get(i);
                    mainjframe.theHash.addToBucket(empAdding);
                } else if (LoadedList.get(i) instanceof FullTimeEmployee) {
                    FullTimeEmployee empAdding = (FullTimeEmployee) LoadedList.get(i);
                    mainjframe.theHash.addToBucket(empAdding);
                    System.out.println(mainjframe.theHash);
                    //FullTimeEmployee empAdding = new FullTimeEmployee(LoadedList.get(i).getEmployeeNumber(),
                    //LoadedList.get(i).getEmployeeFirstName(), LoadedList.get(i).getEmployeeLastName(), LoadedList.get(i).getEmployeeSex(), LoadedList.get(i).getEmployeeWorkLocation(),
                    //LoadedList.get(i).getDeductionRate(),LoadedList.get(i).getYearlySalary());
                    //mainjframe.theHash.addToBucket(empAdding);
                }
            employeesToDisplay();
            displayTableInfo();
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
        catch (Exception v){
        v.printStackTrace();
            System.out.println("Normal Exception was found...");
        return;
        }
    }

    public static void employeesToDisplay() {
        for (int tablepos = 0; tablepos < bigbuckets.length; tablepos++) {
            for (int i = 0; i < bigbuckets[tablepos].size(); i++) {
                addingtojtable.add(bigbuckets[tablepos].get(i));
            }
        }
    }
    public static void resetArrayList(ArrayList <EmployeeInfo> list) {
    for (int o =0; o < list.size();o++){
        list.remove(o);
    }
  }

    public static void displayTableInfo()  {
        DefaultTableModel model = (DefaultTableModel) EmployeeTable.employeeTable.getModel();
        model.setRowCount(0);
        System.out.println(addingtojtable.toString());
        for (int orderingEmp = 0; orderingEmp < addingtojtable.size(); orderingEmp++) {
            EmployeeInfo currentEmp = addingtojtable.get(orderingEmp);
            if (currentEmp instanceof FullTimeEmployee) {
                FullTimeEmployee l = (FullTimeEmployee) currentEmp;
                model.addRow(new Object[]{l.getEmployeeNumber(), l.getEmployeeFirstName(), l.getEmployeeLastName(), "FullTime"});    
                    }
            else if (currentEmp instanceof PartTimeEmployee) {
                PartTimeEmployee r = (PartTimeEmployee) currentEmp;
                model.addRow(new Object[]{r.getEmployeeNumber(), r.getEmployeeFirstName(), r.getEmployeeLastName(), "PartTime"});       
                        }
                }
        resetArrayList(addingtojtable);
            
    } 
                    

                
            

        

    
}
