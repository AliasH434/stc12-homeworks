package hw4;

/*      Создать класс ObjectBox, который будет хранить коллекцию Object. В нем должны быть все методы из MathBox.
        Методы должны работать корректно когда все элементы коллекции-Number.
 *       Если в коллекции есть не Number, должен бросаться Exception, разработанный самостоятельно.

 *       У класса должен быть метод addObject, добавляющий объект в коллекцию.

 *      У класса должен быть метод findObject, проверяющий наличие объекта в коллекции.

 *      Должен быть метод dump, выводящий содержимое коллекции в строку.
 */

import hw3.MathBox;

public class Main {
    public static void main(String[] args) {
        ObjectBox objectBox = new ObjectBox(10);
        MathBox mathBox = new MathBox();

        System.out.println(objectBox);
        System.out.println("Метод Mathbox.Сумма элементов равна: " + mathBox.summator());
        System.out.println("Метод Mathbox.Коллекция после деления = " + mathBox.splitter(2));
        objectBox.addObject(222);
        objectBox.addObject(333);
        System.out.println(objectBox.dump());
        objectBox.findObject(2);
    }
}