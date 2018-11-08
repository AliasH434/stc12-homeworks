package hw4_2;

public class Main {
    public static void main(String[] args) {
        MathClass mathBox = new MathClass();
        System.out.println(mathBox.toString());
        System.out.println("Сумма элементов равна: " + mathBox.summator());
        System.out.println("Коллекция после деления = " + mathBox.splitter(2));
        mathBox.findObject(2);
    }
}