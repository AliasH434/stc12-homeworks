package hw5;

/*Существует класс Employee с полями name, age, salary, job. Типы необходимо выбрать самостоятельно. Задание:

        1.      Реализовать следующие методы:

        a.      boolean save (Employee), дописывающий сотрудника в конец файла
        b.      boolean delete (Employee), удаляющий сотрудника из файла
        c.      Employee getByName (тип name), возвращающий сотрудника по полному совпадению имени
        d.      List<Employee> getByJob(тип job), возвращающий список сотрудников по должности

        e.      boolean saveOrUpdate (Employee), выполняющий обновление, либо сохранение сотрудника в зависимости от того, есть ли он уже в файле
        f.       boolean changeAllWork (какую должноcть, на какую должность), выполняющий замену заданной должности на заданную для всех сотрудников

        g.      Используем сериализацию/десериализацию «Из коробки»
        2.      Доп. Задание (+10%) в конец файла дописывать сумму зарплат всех сотрудников (с помощью Externalizable)
        3.      Доп. Задание (+10%) сделать все на кастомной сериализции/десериализации (BufferedReader/BufferedWriter)
*/

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WriteToFile writeToFile = new WriteToFile();
        writeToFile.clearFileEmployee();

        ArrayList<Employee> employees = new ArrayList();
        Employee employee1 = new Employee(1, "Rustik", 34, 40000, "Nizhnekamskneftehim");
        Employee employee2 = new Employee(2, "Mars", 33, 60000, "Nizhnekamskneftehim");
        Employee employee3 = new Employee(3, "Serega", 33, 40000, "Nizhnekamskshina");
        Employee employee4 = new Employee(4, "Vadim", 37, 65000, "ABB");
        Employee employee5 = new Employee(5, "Alex", 37, 30000, "ABB");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        Employee.save(employee1);
        Employee.save(employee2);
        Employee.save(employee3);
        Employee.save(employee4);
        Employee.save(employee5);

        Employee newEmployee = new Employee(6, "Egor", 18, 0, "No job ");
        Employee.save(newEmployee);

        System.out.println("\n Список сотрудников в файле после удаления");
        Employee.delete(employee1);

        ReadFile readFile = new ReadFile();
        readFile.readEmployeeOnFile();

        System.out.println("\n Вернем сотрудника по полному совпадению имени");
        Employee.getByStringObject("Serega");

        System.out.println("\n Вернем сотрудников по полному совпадению места работы");
        Employee.getByStringObject("ABB");

        //       System.out.println("\n Заменим место работы сотрудника");
        //       Employee.saveOrUpdate("ABB","AkBarsBank");

    }

}
