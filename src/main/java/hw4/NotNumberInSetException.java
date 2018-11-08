package hw4;

public class NotNumberInSetException extends Exception {
    public NotNumberInSetException(String message) {

        System.out.println("Без паники, продолжаем работать! Тип данных должен быть Number. Исправь! )");
    }
}