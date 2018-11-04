package hw2;

public class MathBox {

    public int summa(Integer a, Integer b) {
        return a + b;
    }

    public int diff(Integer a, Integer b) {
        return a - b;
    }

    public long factorial(Integer a) {
        if (a == 1) return 1;
        return factorial(a - 1) * a;
    }

    public double dividerExceptionInside(Integer a, Integer b) {
        int result = 0;
        if (b == 0) {
            System.out.print("Деление на 0? ну ладно... результат ");
        } else {
            result = a / b;
        }
        return result;
    }

    public double divider(Integer a, Integer b) throws ArithmeticException {
        return a / b;
    }
}



