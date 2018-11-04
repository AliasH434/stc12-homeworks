package ru.innopolis.stc12.hw5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyOutputStream {

    public void outputEmployee(Employee employee) {

        try (DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream("notes.txt", true))) {
            dataOutput.writeUTF(employee.getName());
            dataOutput.writeInt(employee.getAge());
            dataOutput.writeInt(employee.getSalary());
            dataOutput.writeUTF(employee.getJob());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}