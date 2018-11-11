package hw4_2;
/*
Вторая часть задания, творческая:

Получившиеся классы MathBox и ObjectBox не имеют связи между собой. Это неправильно. Логичнее было бы сделать MathBox наследником ObjectBox.
Необходимо сделать такую связь, правильно распределить поля и методы. Функциональность в целом должна сохраниться. Руководствуемся здравым смыслом и своей фантазией.

Задание выполняется в одной ветке. Каждая часть в отдельном пакете.
 */

public class Main {
    public static void main(String[] args) {
        MathBox2 mathBox = new MathBox2(50);
        System.out.println(mathBox.toString());
        System.out.println("Сумма элементов равна: " + mathBox.summator());
        System.out.println("Коллекция после деления = " + mathBox.splitter(2));
        mathBox.findObject(2);
    }
}