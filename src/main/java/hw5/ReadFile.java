package hw5;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReadFile {

    public List<String> readEmployeeOnFile() {
        Map<String, String> employeesData = new TreeMap<>();
        List<String> employeeList = new ArrayList<>();
        try (DataInputStream dataInput = new DataInputStream(new FileInputStream("notes.txt"))) {
            while (dataInput.available() > 0) {
                int emplID = dataInput.readInt();
                String name = dataInput.readUTF();
                int age = dataInput.readInt();
                int salary = dataInput.readInt();
                String job = dataInput.readUTF();

                employeeList.add("\nEmployee ID: " + emplID + ", имя: " + name + ", возраст: " + age + ", зарплата: " + salary + ", место работы: " + job);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        for (String emp : employeeList) {
            System.out.println(emp);
        }
        return employeeList;
    }
}
