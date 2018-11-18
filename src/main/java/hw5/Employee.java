package hw5;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int employeeID;
    private String name;
    private int age;
    private int salary;
    private String job;

    public Employee(int employeeID, String name, int age, int salary, String job) {
        this.employeeID = employeeID;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.job = job;
    }

    public static boolean save(Employee employee) {
        boolean ifRecordSuccess = false;
        WriteToFile writeToFile = new WriteToFile();
        writeToFile.outputEmployeeToFile(employee);
        System.out.println("Добавлена запись о сотруднике " + employee.employeeID);
        ifRecordSuccess = true;
        return ifRecordSuccess;
    }

    public static boolean delete(Employee employee) {
        boolean ifRecordSuccess = false;
        List<String> listOfEmpl = new ArrayList<String>();
        List<String> newListOfEmpl = new ArrayList<String>();

        ReadFile readFile = new ReadFile();
        listOfEmpl = readFile.readEmployeeOnFile();

        for (String emp : listOfEmpl) {

            if (!emp.contains("Employee ID: " + employee.getEmployeeID())) {
                newListOfEmpl.add(emp);
                ifRecordSuccess = true;
            }
        }

        WriteToFile writeToFile = new WriteToFile();
        writeToFile.clearFileEmployee();

        String[] values = null;
        int id = 0;
        String name = null;
        int age = 0;
        int salary = 0;
        String job = null;
        for (String emp : newListOfEmpl) {
            String[] val = emp.split(":");
            for (int i = 1; i < val.length - 1; i++) {
                values = val[i].split(",");
                if (i == 1) id = Integer.parseInt(values[0].trim());
                if (i == 2) name = values[0].trim();
                if (i == 3) age = Integer.parseInt(values[0].trim());
                if (i == 4) salary = Integer.parseInt(values[0].trim());
                job = val[5].trim();
            }
            writeToFile.outputEmployeeToFile(new Employee(id, name, age, salary, job));
        }


        return ifRecordSuccess;
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

    public static Employee getByName(String name) {

        List<String> listOfEmpl = new ArrayList<String>();
        ReadFile readFile = new ReadFile();
        listOfEmpl = readFile.readEmployeeOnFile();

        for (String emp : listOfEmpl) {
            if (emp.contains(name)) {
                System.out.println(emp);
            }
        }
        return null;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

}