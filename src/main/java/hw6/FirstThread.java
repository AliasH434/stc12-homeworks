package hw6;

/*
один поток которой каждую секунду отображает на экране данные о времени,
прошедшем от начала сессии
 */

public class FirstThread extends Thread {
    long start = System.currentTimeMillis();

    public void FirstThread() {
        this.start = start;
    }

    @Override
    public void run() {
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.println(timeWorkCode);
    }
}
