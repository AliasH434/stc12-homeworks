package hw5;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {

    public void outputEmployeeToFile(Employee employee) {
        try (DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream("notes.txt", true))) {
            dataOutput.writeInt(employee.getEmployeeID());
            dataOutput.writeUTF(employee.getName());
            dataOutput.writeInt(employee.getAge());
            dataOutput.writeInt(employee.getSalary());
            dataOutput.writeUTF(employee.getJob());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void clearFileEmployee() {
        File file = new File("notes.txt");
        file.delete();
    }
}