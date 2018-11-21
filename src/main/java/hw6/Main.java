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

public class Main {

    public Main(int lifetime) throws InterruptedException {
        FirstThread firstThread = new FirstThread();
        SecondThread secondThread = new SecondThread(5000, "Hello ");
        ThirdThread thirdThread = new ThirdThread(7000, "my friend");
        firstThread.start();
        secondThread.start();
        thirdThread.start();
        Thread.sleep(lifetime * 1000 + 100);
        firstThread.interrupt();
        secondThread.interrupt();
        thirdThread.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        new Main(15);
    }
}



