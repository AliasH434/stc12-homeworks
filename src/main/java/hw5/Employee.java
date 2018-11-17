package hw5;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private int age;
    private int salary;
    private String job;

    public Employee(String name, int age, int salary, String job) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public static boolean save(Employee employee) {
        boolean ifRecordSuccess = false;
        WriteToFile writeToFile = new WriteToFile();
        writeToFile.outputEmployeeToFile(employee);
        ifRecordSuccess = true;
        return ifRecordSuccess;
    }

    public static boolean delete(Employee employee) {
        boolean ifRecordSuccess = false;
        List<String> listOfEmpl = new ArrayList<String>();
        ReadFile readFile = new ReadFile();
        listOfEmpl = readFile.readEmployeeOnFile();

        System.out.println("\ndelete method");
        System.out.println(listOfEmpl);


        File tempFile = new File("notes2.txt");


        return ifRecordSuccess;
    }

    public static boolean getByName(String name) {
        boolean ifRecordSuccess = false;
        ReadFile readFile = new ReadFile();
        readFile.readEmployeeOnFile();

//        for (Employee employee : employees) {
//            if (name.equals(employee.getName())) {
//                return employee;
//            }
//        }
        return ifRecordSuccess;
    }

}
