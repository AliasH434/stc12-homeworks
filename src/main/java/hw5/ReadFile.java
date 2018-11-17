package hw5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReadFile {

    public Map<String, String> readEmployeeOnFile() {
        Map<String, String> employeesData = new TreeMap<>();
        List<String> employeeList = new ArrayList<>();
        try (DataInputStream dataInput = new DataInputStream(new FileInputStream("notes.txt"))) {
            while (dataInput.available() > 0) {
                String name = dataInput.readUTF();
                int age = dataInput.readInt();
                int salary = dataInput.readInt();
                String job = dataInput.readUTF();
                employeesData.put("Имя", name);
                employeesData.put("возраст", String.valueOf(age));
                employeesData.put("зарплата", String.valueOf(salary));
                employeesData.put("место работы", job);


//                employeeList.add("\nИмя: " + name + ", возраст: " + age + ", зарплата: " + salary + ", место работы: " + job);
                System.out.printf("\nИмя: %s, возраст: %d, зарплата: %d, место работы: %s", name, age, salary, job);
            }
        } catch (
                IOException ex) {
            System.out.println(ex.getMessage());
        }
        return employeeList;
    }

    public List<String> readEmployees() {
        List<String> employeeList = new ArrayList<>();
        try (DataInputStream dataInput = new DataInputStream(new FileInputStream("notes.txt"))) {
            BufferedReader br = new BufferedReader(new InputStreamReader(dataInput));
            String line = null;
            while ((line = br.readLine()) != null) {
                employeeList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String emp : employeeList) {
            System.out.println(emp);
        }
        return employeeList;
    }
}
