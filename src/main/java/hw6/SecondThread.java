package hw6;

/*
другой ее поток выводит сообщение каждые 5 секунд
 */

public class SecondThread extends Thread {
    Object monitor;

    public void setMonitor(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        synchronized (monitor) {
            System.out.println(Thread.currentThread().getName() + " locked monitor");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "releasing monitor");
        }
    }
}
