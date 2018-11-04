package hw2;
/*
 * Домашняя работа №2 Исмагилова Ильяса
 * Разработать класс MathBox со следующими методами:

public int summa (Integer a, Integer b);

public int diff (Integer a, Integer b);

public long factorial (Integer a);

public double dividerExceptionInside(Integer a, Integer b);

public double divider (Integer a, Integer b) throws Exception)

В реализации метода factorial должна быть ошибка, приводящая к OutOfMemory, или StackOverflow.
Методы, выполняющие деление, в одном случае должны не допускать появление исключения при делении на 0, в другом пробрасывать его (исходя из сигнатуры метода).

Опционально:  поменять сигнатуру метода, пробрасывающего исключение так, чтобы он бросал собственный тип исключения. Описать это исключение в отдельном классе.

 */

public class Main {
    public static void main(String[] args) {
        MathBox mathBox = new MathBox();
        System.out.println(mathBox.summa(7, 4));
        System.out.println(mathBox.diff(20, 5));
        System.out.println(mathBox.factorial(6));
        System.out.println(mathBox.dividerExceptionInside(6, 0));
        try {
            System.out.println(mathBox.divider(2, 0));
        } catch (ArithmeticException e) {
            System.out.println("При делении на ноль получили обработаный Exception");
        }
    }
}
