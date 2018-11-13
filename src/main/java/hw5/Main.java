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
        ArrayList<Employee> employees = new ArrayList();
        Employee employee1 = new Employee("Rustik", 34, 40000, "Nizhnekamskneftehim ");
        Employee employee2 = new Employee("Mars", 33, 60000, "Nizhnekamskneftehim ");
        Employee employee3 = new Employee("Serega", 33, 40000, "Nizhnekamskshina ");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        Employee.save(employee1);
        Employee.save(employee2);
        Employee.save(employee3);
        Employee.delete(employee2);

        Employee newEmployee = new Employee("Egor", 18, 0, "Non job ");
        Employee.save(newEmployee);


        //     MyInputStream.readArrayEmployee();

    }

}
