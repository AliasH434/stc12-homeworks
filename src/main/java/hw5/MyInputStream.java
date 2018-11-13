package hw5;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MyInputStream {

    public static void readEmployeeOnFile() {
        try (DataInputStream dataInput = new DataInputStream(new FileInputStream("notes.txt"))) {
            while (dataInput.available() > 0) {
                String name = dataInput.readUTF();
                int age = dataInput.readInt();
                int salary = dataInput.readInt();
                String job = dataInput.readUTF();
                System.out.printf("\nИмя: %s, возраст: %d, зарплата: %d, место работы: %s", name, age, salary, job);
            }
        } catch (
                IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
