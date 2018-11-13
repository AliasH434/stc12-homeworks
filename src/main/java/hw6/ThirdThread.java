package hw6;

/*
Не внося изменений в код потока-"хронометра" , добавьте еще один поток, который выводит на
экран другое сообщение каждые 7 секунд
 */

public class ThirdThread extends Thread {
    Object monitor;

    public void setMonitor(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
    }
