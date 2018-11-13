package hw6;

/*
один поток которой каждую секунду отображает на экране данные о времени,
прошедшем от начала сессии
 */

public class FirstThread extends Thread {
    Object time;

    public void setTime(Object time) {
        this.time = time;
    }

    @Override
    public void run() {

    }
}
