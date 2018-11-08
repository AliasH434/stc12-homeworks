package hw4;

/*      Создать класс ObjectBox, который будет хранить коллекцию Object. В нем должны быть все методы из MathBox.
        Методы должны работать корректно когда все элементы коллекции-Number.
 *       Если в коллекции есть не Number, должен бросаться Exception, разработанный самостоятельно.

 *       У класса должен быть метод addObject, добавляющий объект в коллекцию.

 *      У класса должен быть метод findObject, проверяющий наличие объекта в коллекции.

 *      Должен быть метод dump, выводящий содержимое коллекции в строку.
 *
 *      Вторая часть задания, творческая:

Получившиеся классы MathBox и ObjectBox не имеют связи между собой. Это неправильно. Логичнее было бы сделать MathBox наследником ObjectBox. Необходимо сделать такую связь, правильно распределить поля и методы. Функциональность в целом должна сохраниться. Руководствуемся здравым смыслом и своей фантазией.

Задание выполняется в одной ветке. Каждая часть в отдельном пакете.
 */

public class Main {
    public static void main(String[] args) throws NotNumberInSetException {
        ObjectBox objectBox = new ObjectBox(50);
        System.out.println(objectBox.dump());
        System.out.println("Сумма элементов objectBox равна : " + objectBox.summator());
        System.out.println("Коллекция после деления objectBox будет: " + objectBox.splitter(2));
        objectBox.addObject("222");
        objectBox.addObject(333);
        System.out.println(objectBox.dump());
        objectBox.findObject(2);
    }
}