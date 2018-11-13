package hw6;
/*
Напишите программу, один поток которой каждую секунду отображает на экране данные о времени,
прошедшем от начала сессии, а другой ее поток выводит сообщение каждые 5 секунд.
Предусмотрите возможность ежесекундного оповещения потока, воспроизводящего сообщение,
потоком, отсчитывающим время. Отсчитывать время (использовать sleep) может только один поток
Не внося изменений в код потока-"хронометра" , добавьте еще один поток, который выводит на
экран другое сообщение каждые 7 секунд. Предполагается использование методов wait(),
notifyAll() по какому-то монитору, общему для всех потоков.

Бонус: Пакет Concurrent, перевод примеров на Lock  вместо синхронизации через wait-notify
 */

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Object monitor = new Object();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            MonitorThread thread = new MonitorThread();
            thread.setMonitor(monitor);
            thread.start();
            threadList.add(thread);

        }
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("finished");
    }
}
